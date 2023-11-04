/*
 * Copyright (C) 2023 jones
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.jonesdev.snbt2nbt;

import lombok.experimental.UtilityClass;
import net.kyori.adventure.nbt.BinaryTagIO;
import net.kyori.adventure.nbt.CompoundBinaryTag;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

@UtilityClass
public class SNBTConverter {

  /**
   * Converts a SNBT file into a {@link net.kyori.adventure.nbt.CompoundBinaryTag}
   *
   * @param path Path from which .snbt file the data should be read
   * @param compression Binary tag compressor used for reading
   * @return Converted {@link net.kyori.adventure.nbt.CompoundBinaryTag}
   */
  public static @NotNull CompoundBinaryTag from(final @NotNull Path path,
                                                final BinaryTagIO.Compression compression) {
    final SNBTProcessedFile processedFile = SNBTProcessedFile.from(path);
    return processedFile.convert(compression);
  }

  /**
   * Saves a file containing converted NBT data from a raw SNBT file
   *
   * @param from Path from which .snbt file the data should be read
   * @param to Path to which .nbt file the data should be written
   * @param compression Binary tag compressor used for reading and writing
   * @return Converted {@link net.kyori.adventure.nbt.CompoundBinaryTag}
   */
  public static @NotNull CompoundBinaryTag snbt2nbt(final @NotNull Path from,
                                                    final @NotNull Path to,
                                                    final BinaryTagIO.Compression compression) {
    final CompoundBinaryTag convertedSNBT = from(from, compression);

    try {
      BinaryTagIO.writer().write(convertedSNBT, to);
    } catch (Throwable throwable) {
      throw new NBTWriteException(throwable);
    }
    return convertedSNBT;
  }
}

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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.nbt.BinaryTagIO;
import net.kyori.adventure.nbt.CompoundBinaryTag;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class SNBTProcessedFile extends SNBTReader {
  private final Path path;
  private final String content;

  /**
   * Reads the given file and processes the text-based nbt data
   *
   * @param path Path to the raw text-based nbt file
   * @return SNBT file wrapper for easier conversion
   */
  public static @NotNull SNBTProcessedFile from(final @NotNull Path path) {
    try {
      return new SNBTProcessedFile(path, read(path));
    } catch (Throwable throwable) {
      throw new SNBTReadException(throwable);
    }
  }

  /**
   * Converts the {@link java.lang.String content} into a {@link net.kyori.adventure.nbt.CompoundBinaryTag}
   *
   * @param compression Binary tag compressor used for reading
   * @return Converted {@link net.kyori.adventure.nbt.CompoundBinaryTag}
   */
  public @NotNull CompoundBinaryTag convert(final BinaryTagIO.Compression compression) {
    try (final InputStream inputStream = Files.newInputStream(path)) {
      return BinaryTagIO.reader().read(Objects.requireNonNull(inputStream), compression);
    } catch (Throwable throwable) {
      throw new SNBTConvertException(throwable);
    }
  }
}

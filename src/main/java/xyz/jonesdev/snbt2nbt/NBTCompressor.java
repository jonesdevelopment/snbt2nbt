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

import lombok.RequiredArgsConstructor;
import net.kyori.adventure.nbt.BinaryTagIO;

/**
 * Small wrapper for all {@link BinaryTagIO.Compression} types for easier API usage
 */
@RequiredArgsConstructor
public enum NBTCompressor {
  GZIP(BinaryTagIO.Compression.GZIP),
  ZLIB(BinaryTagIO.Compression.ZLIB),
  NONE(BinaryTagIO.Compression.NONE);

  final BinaryTagIO.Compression tagCompressor;
}

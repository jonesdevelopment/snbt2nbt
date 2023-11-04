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

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

abstract class SNBTReader {
  private static final String LINE_SEPARATOR = "\n"; // TODO: does this break Windows?

  /**
   * Converts the content of the file into one single line of text
   *
   * @param path Path to the raw text-based nbt file
   * @return Single-line file content
   */
  static @NotNull String read(final @NotNull Path path) throws IOException {
    final Collection<String> allLines = Files.readAllLines(path);
    return String.join(LINE_SEPARATOR, allLines);
  }
}

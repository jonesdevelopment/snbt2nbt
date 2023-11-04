<div align="center">
  <!-- Introduction -->
  <p>
    <h1>snbt to nbt</h1>
    Simple library for converting and compressing stringified nbt (.snbt) files into .nbt files.
    <br>
    Used by <a href="https://github.com/jonesdevelopment/sonar">Sonar</a> for processing compressed NBT mappings for Minecraft packets
  </p>

  <!-- Badges & icons -->
  [![](https://img.shields.io/github/issues/jonesdevelopment/snbt2nbt)](https://github.com/jonesdevelopment/snbt2nbt/issues)
  [![](https://img.shields.io/discord/923308209769426994.svg?logo=discord)](https://jonesdev.xyz/discord)
  [![](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
  <br>
  <br>
  <!-- Quick navigation -->
  [Issues](https://github.com/jonesdevelopment/snbt2nbt/issues)
  |
  [Pull Requests](https://github.com/jonesdevelopment/snbt2nbt/pulls)
  |
  [Discord](https://jonesdev.xyz/discord)
  |
  [License](https://github.com/jonesdevelopment/snbt2nbt/blob/main/README.md#license)
</div>

## How to use

1. Add the [dependency](https://repo.jonesdev.xyz/#/releases/xyz/jonesdev/snbt2nbt/) to your project
2. Prepare your `.snbt` file you would like to read/convert.

### Example code

Convert [SNBT](https://minecraft.wiki/w/NBT_format#SNBT_format) to NBT
```java
final Path snbt = new File("test.snbt").toPath();
final CompoundBinaryTag converted = SNBTConverter.from(snbt);
```
Save the converted SNBT to a NBT file
```java
final Path snbt = new File("test.snbt").toPath();
final Path nbt = new File("test-output.nbt").toPath();
// snbt2nbt(Path,Path) uses GZIP compression by default
SNBTConverter.snbt2nbt(snbt, nbt);
```
Use a compressor (GZIP, ZLIB, NONE)
```java
// ...
SNBTConverter.snbt2nbt(snbt, nbt, NBTCompressor.GZIP);
```

[Read more about NBT](https://minecraft.wiki/w/NBT_format)

## License

snbt2nbt is licensed under the [GNU General Public License 3.0](https://www.gnu.org/licenses/gpl-3.0.en.html).

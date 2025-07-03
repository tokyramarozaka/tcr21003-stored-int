package school.storedint.hei.file.hash;

import school.storedint.hei.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}

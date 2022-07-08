package br.com.alura.ecommerce;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class IO {
    public static void copyTo(Path source, File target) throws IOException {
        target.getParentFile().mkdir(); // cria os diretórios
        Files.copy(source, target.toPath(), StandardCopyOption.REPLACE_EXISTING); //copia arquivo e substitui se ja existir
    }
    public static void append(File target, String content) throws IOException {
        Files.write(target.toPath(), content.getBytes(), StandardOpenOption.APPEND); //acrescenta no arquivo
    }
}
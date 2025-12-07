package com.pots.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {

    private String path;
    private File arquivo;

    public FileLoader(String path){
        this.path = path;
    }   

    public void carregarArquivo(){
        arquivo = new File(path);
        try {
            Scanner in = new Scanner(arquivo);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }
    }
}

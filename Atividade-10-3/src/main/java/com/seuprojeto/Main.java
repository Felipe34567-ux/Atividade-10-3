package com.seuprojeto;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {
    GerenciadorNomes gNomes = new GerenciadorNomesMem();
    Ihm ihm = new Ihm(gNomes);
    ihm.dialogar();
    }
   }
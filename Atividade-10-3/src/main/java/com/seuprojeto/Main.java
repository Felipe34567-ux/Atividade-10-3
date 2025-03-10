// Felipe Ferreira Melantonio RA: 10443843 , Guilherme Sampaio Silva RA:10443768
package com.seuprojeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorNomesBD gerenciador = new GerenciadorNomesBD();
        System.out.println(">> Conectado ao banco de dados PostgreSQL.");

        Ihm ihm = new Ihm(gerenciador);
        ihm.dialogar();

        scanner.close();
    }
  }

// Felipe Ferreira Melantonio RA: 10443843 , Guilherme Sampaio Silva RA:10443768
package com.seuprojeto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements GerenciadorNomes {
    private final String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?user=postgres.pjtvsqcoqrejvozpebzj&password=fgvdrstuvjwxyzdhg";

    public GerenciadorNomesBD() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS nomes (id SERIAL PRIMARY KEY, nome VARCHAR(20) NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM nomes";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() > MAX_CARACTERES_NOMES) {
            System.out.println("Erro: Nome excede o limite de caracteres!");
            return;
        }

        String sql = "INSERT INTO nomes (nome) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }


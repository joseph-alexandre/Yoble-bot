package Application.Database.DAO;

import Application.Bean.Historico;
import Application.Database.Conexao.ConnectionFactory;

import java.io.*;
import java.sql.*;

public class DAO {

    public static void inserirHistorico(Historico historico){

        try  {
            String sql = "INSERT INTO resources(data, hora, avatar_atual) VALUES(?, ?, ?)";
            Connection conexao = ConnectionFactory.obterConexao();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, historico.getData());
            pstmt.setString(2, historico.getHora());
            pstmt.setString(3, historico.getArquivoAtual());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao();
        }
    }

    public static void criarHistorico(String path) {
        File arquivo = new File(path);
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT data, hora, avatar_atual FROM resources";

        try {

            PrintWriter pw = new PrintWriter(arquivo);
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            while(rs.next()){
                pw.println("Seu avatar foi alterado às " + rs.getString("hora") + " do dia " + rs.getString("data")
                +"." + " Avatar atual: " + rs.getString("avatar_atual"));
            }
            pw.flush();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }

    }
    public static void inserirPrimeiroAvatar(String data, String hora, String path){
        Historico historico = new Historico();
        historico.setData(data);
        historico.setHora(hora);
        historico.setArquivoAtual(path);
        inserirHistorico(historico);
    }

    public static String getAvatarAtual(){
        Connection conexao = ConnectionFactory.obterConexao();
        String avatarAtual = "";
        String sql = "SELECT avatar_atual FROM resources WHERE ROWID = (SELECT max(ROWID) FROM resources)";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            avatarAtual = rs.getString("avatar_atual");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.fecharConexao();
        }
        return avatarAtual;
    }
    public static boolean temRegistro(){
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT * FROM resources";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            if(rs.isClosed()){
            return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return true;
    }


}

package Chrome.database.DAO;

import Chrome.Bean.Historico;
import Chrome.database.Conexao.ConnectionFactory;
import org.flywaydb.core.internal.database.sqlite.SQLiteDatabase;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static void inserirHistorico(Historico historico){

        try  {
            String sql = "INSERT INTO resources(data, hora) VALUES(?, ?)";
            Connection conexao = ConnectionFactory.obterConexao();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, historico.getData());
            pstmt.setString(2, historico.getHora());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void criarHistorico(String path) {
        File arquivo = new File(path);
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT data, hora FROM resources";

        try {

            PrintWriter pw = new PrintWriter(arquivo);
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            while(rs.next()){
                pw.println("Seu avatar foi alterado às " + rs.getString("hora") + " do dia " + rs.getString("data"));
            }
            pw.flush();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

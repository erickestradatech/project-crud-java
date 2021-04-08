package controlador;

import util.MySQLConexion;
import java.util.*;
import modelo.Empleado;
import java.sql.*;

public class Negocio {

    public int adicionar(Empleado ep) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into empleado values(?,?,?,?)";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, ep.getCode());
            st.setString(2, ep.getNome());
            st.setInt(3, ep.getHora());
            st.setDouble(4, ep.getTar());
            resp = st.executeUpdate();

        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return resp;
    }

    //para modificar
    public int modifica(Empleado ep) {
        int resp = 0;
        Connection conn = null;
        try {

            String sql = "update empleado set nombre=?,horas=?,tarifa=? where code=?";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(4, ep.getCode());
            st.setString(1, ep.getNome());
            st.setInt(2, ep.getHora());
            st.setDouble(3, ep.getTar());
            resp = st.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return resp;
    }

    public int anula(String cod) {
        int resp = 0;
        Connection conn = null;
        try {

            String sql = "delete from empleado where code=?";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, cod);
            resp = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return resp;
    }

    public List<Empleado> Listado() {

        List<Empleado> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from Empleado";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Empleado a = new Empleado();
                a.setCode(rs.getString(1));
                a.setNome(rs.getString(2));
                a.setHora(rs.getInt(3));
                a.setTar(rs.getDouble(4));
                lis.add(a);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return lis;
    }

    public Empleado consulta(String cod) {

        Empleado a = null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select nome,horas,tarifa from Empleado where code=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Empleado();
                a.setNome(rs.getString(1));
                a.setHora(rs.getInt(2));
                a.setTar(rs.getDouble(3));
                a.setCode(cod);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }

        }

        return a;
    }

}

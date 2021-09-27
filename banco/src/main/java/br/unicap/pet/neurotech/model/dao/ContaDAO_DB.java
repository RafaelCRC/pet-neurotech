package br.unicap.pet.neurotech.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import java.sql.ResultSet;

import java.sql.Statement;


import br.unicap.pet.neurotech.model.exceptions.*;

public class ContaDAO_DB implements ClienteDAO{

    private static ContaDAO_DB self;

    private int logged;
    private UserAbs loggedGerente;
    private List<UserAbs> gerentes;

    private Connection con;

    private ContaDAO_DB(){
        gerentes = new ArrayList<UserAbs>();
    }

    public static ContaDAO_DB getInstance(){
        if (self == null){
            self = new ContaDAO_DB();
        }
        return self;
    }

    @Override
    public void registro(String login, String senha, int tipoConta, boolean isGerente) throws ContaJaExisteException {

        UserAbs novoUser;

        if (isGerente) {
            if (!buscarContaGerente(login)) {
                novoUser = new UserGerente(login, senha);
                this.gerentes.add(novoUser);
            } else {
                throw new ContaJaExisteException();
            }
        } else {
            if (!buscarConta(login)){
                String query = "INSERT INTO ContaRafael (userLogin, userPassword, accountType)"
                +"VALUES('"+login+"', "+senha+", "+tipoConta+");";
        
                try {
                    Statement st = con.createStatement();
                    st.execute(query);
                } catch (SQLException e){
                    e.printStackTrace();
                }
            } else {
                throw new ContaJaExisteException();
            }
        }
        
        
    }

    @Override
    public void logIn(String login, String senha, int isGerente) throws 
    DadosLoginErradoException {

        int id = -1;
        String userLogin = null;
        String userPassword = null;

        if (isGerente == 2) { //colocar gerente na bd
            for (UserAbs user : gerentes) {
                if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                    loggedGerente = user;
                    return;
                }
            }
            throw new DadosLoginErradoException();
        } else {
            String query = "SELECT * FROM ContaRafael where userLogin = '"
            +login+"';";
    
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    id = rs.getInt("userId");
                    userLogin = rs.getString("userLogin");
                    userPassword = rs.getString("userPassword");
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            
            if (login.equals(userLogin) && senha.equals(userPassword)){
                attLogged(id);
            } else {
                throw new DadosLoginErradoException();
            }
        }
        
    }

    @Override
    public void attLogged(int id) {
        this.logged = id;
        
    }

    @Override
    public void logOut() {
        this.logged = -1;
        this.loggedGerente = null;
        
    }

    @Override
    public boolean buscarConta(String login) {
        int id = -1;

        String query = "SELECT * FROM ContaRafael where userLogin = '"
        +login+"';";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("userId");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        
        if (id == -1){
            return false;
        }
        return true;
    }

    @Override
    public boolean buscarContaGerente(String login) { //nao esta db
        boolean encontrado = false;
        for (UserAbs user : gerentes) {
            if (user.getLogin().equals(login)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void criarConta(String login, String senha, int tipoConta) throws 
    ContaJaExisteException {

        if (buscarConta(login)) {
            throw new ContaJaExisteException();
        }

        String query = "INSERT INTO ContaRafael (userLogin, userPassword, accountType)"
        +"VALUES('"+login+"', "+senha+", "+tipoConta+");";

        try {
            Statement st = con.createStatement();
            st.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void remover(String login) throws ContaInexistenteException {
        int id = -1;

        String query = "SELECT * FROM ContaRafael where userLogin = '"
        +login+"';";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("userId");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        
        if (id == -1){
            throw new ContaInexistenteException();
        } else {
            String query2 = "DELETE FROM ContaRafael WHERE userId = "+id+";";
            try {
                Statement st = con.createStatement();
                st.execute(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void bonifica(String login) throws ContaInexistenteException, ContaTipoErradoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getConta(String login) throws ContaInexistenteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getContas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sacarConta(float quantia) throws SaldoInsuficienteException, ValorInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void depositarConta(float quantia) throws ValorInvalidoException {
        if (quantia < 0) {
            throw new ValorInvalidoException();
        }

        float quantiaTemp = getSaldo() + quantia;

        String query = "UPDATE ContaRafael SET ballance = "+quantiaTemp+"  WHERE userId = "+logged+";";
        try {
            Statement st = con.createStatement();
            st.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public Float getSaldo() {
        Float saldo = null;

        String query = "SELECT * FROM ContaRafael where userId = '"
        +logged+"';";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                saldo = rs.getFloat("ballance");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        if (saldo == null){
            saldo = ((float) 0.0);
        }
        return saldo;
    }


    //DB Factory

    @Override
    public void connect(){
        con = ConnectionDB.connect();
    }

    @Override
    public void dis(){
        ConnectionDB.closeConnection(con);
    }
    
}

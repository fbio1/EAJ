package com.example.pichau.conheaeaj20.sqlHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.pichau.conheaeaj20.Setor;
import com.fabio.eaj.conheaeaj.R;


import java.util.ArrayList;
import java.util.List;

public class SetorHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "conhecendoEAJ";
    /*
    private double latitude;
    private double longetude;
    private String nomeSetor;
    private String horarioFuncionamento;
    private String emailResponsavel;
    private String nomeResponsavel;
    private int image;
    private String descricao;
    private String telefone;
    *
    * */

    /* SQL de criação do banco de dados. */
    private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS setor(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome_setor TEXT," +
            "telefone TEXT, " +
            "horario_funcionamento TEXT, " +
            "email_responsavel TEXT, " +
            "nome_responsavel TEXT, " +
            "descricao TEXT, " + //Famoso TEXTAO
            "image INTEGER, " +
            "latitude REAL, " +
            "longitude REAL)";


    private static final String SQL_SELECT_ALL = "SELECT * FROM setor ORDER BY nome_setor";
    private static final String SQL_SELECT_NOME = "SELECT * FROM pessoa WHERE nome = '%s'";
    private static final String SQL_SELECT_ID = "SELECT * FROM pessoa WHERE id = '%s'";

    /* Classe com métodos para executar os comandos SQL e manipular o banco de dados. */
    private SQLiteDatabase banco = getWritableDatabase();
    /* Interface que permite acesso aos dados retornados pelo banco de dados. */
    private Cursor cursor = null;

    /* Índice das colunas no banco de dados */
    private int indexId;
    private int indexNomeSetor;
    private int indexTelefone;
    private int indexHorarioFuncionamento;
    private int indexEmail;
    private int indexNomeResp;
    private int indexDesc;
    private int indexImg;
    private int indexLongitude;
    private int indexLatitude;

    public SetorHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public boolean insert(Setor setor) {

        long id = setor.getId();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome_setor", setor.getNomeSetor());
        contentValues.put("horario_funcionamento", setor.getHorarioFuncionamento());
        contentValues.put("email_responsavel", setor.getEmailResponsavel());
        contentValues.put("nome_responsavel", setor.getNomeResponsavel());
        contentValues.put("descricao", setor.getDescricao());
        contentValues.put("telefone", setor.getTelefone());
        contentValues.put("image", setor.getImage());
        contentValues.put("imageFragment", setor.getImageFragment());
        contentValues.put("latitude", setor.getLatitude());
        contentValues.put("longitude", setor.getLongitude());

        this.banco.insert("setor", null, contentValues);

        if (banco != null)
            return true;
        else
            return false;


    }

    /* Método que recupera todos os registro do banco de dados. */
    public List<Setor> getAll() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            // select * from carro
            Cursor c = db.query("setor", null, null, null, null, null, null, null);
            return toList(c);
        } finally {
            db.close();
        }
    }

    private List<Setor> toList(Cursor c) {

        List<Setor> setores = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                Setor setor = new Setor();
                setores.add(setor);

                // recupera os atributos de carro
                setor.setId(c.getInt(c.getColumnIndex("id")));
                setor.setNomeSetor(c.getString(c.getColumnIndex("nome_setor")));
                setor.setNomeResponsavel(c.getInt(c.getColumnIndex("nome_responsavel")));
                setor.setEmailResponsavel(c.getInt(c.getColumnIndex("email_responsavel")));
                setor.setHorarioFuncionamento(c.getInt((c.getColumnIndex("horario_funcionamento"))));
                setor.setTelefone(c.getString((c.getColumnIndex("telefone"))));
                setor.setLatitude(c.getDouble((c.getColumnIndex("latitude"))));
                setor.setLongitude(c.getDouble((c.getColumnIndex("longitude"))));
                setor.setImage(c.getInt(c.getColumnIndex("image")));
                setor.setImageFragment(c.getInt(c.getColumnIndex("imageFragment")));
                setor.setDescricao(c.getInt(c.getColumnIndex("descricao")));
            } while (c.moveToNext());
        }
        return setores;
    }

    public List createList() {
        List<Setor> listaSetor = new ArrayList<>();

        listaSetor.add(new Setor("Apicultura", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.apicolas, R.string.setor_descricao_apicultura, R.drawable.apico, "Sem Ramal", -5.885880, -35.362644));

        listaSetor.add(new Setor("Aquicultura", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.aqui, R.string.setor_descricao_aquicultura, R.drawable.aqui, "Ramal 226", -5.887602, -35.361685));

        listaSetor.add(new Setor("Avicultura", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.avi, R.string.setor_descricao_avicultura, R.drawable.avi, "Sem Ramal", -5.886730, -35.363363));

        listaSetor.add(new Setor("Biblioteca", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.bibli, R.string.setor_descricao_biblioteca, R.drawable.biblioteca, "Ramal 228", -5.885911, -35.366131));

        listaSetor.add(new Setor("Centro Vocacional Tecnológico - CVT", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.cvt, R.string.setor_descricao_cvt, R.drawable.cvt, "Ramal 209", -5.884567, -35.364924));

        listaSetor.add(new Setor("Diretoria", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.diretoria, R.string.setor_descricao_diretoria, R.drawable.direcao,"Ramal 201", -5.886420, -35.362260));

        listaSetor.add(new Setor("Informática", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.info, R.string.setor_descricao_informatica, R.drawable.info, "Ramal 220", -5.885786, -35.365748));

        listaSetor.add(new Setor("Graduação", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.gradu, R.string.setor_descricao_graduacao, R.drawable.graduacao, "Ramal 215", -5.884536, -35.364029));

        listaSetor.add(new Setor("Lanchonete", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.lanchonete, R.string.setor_descricao_lanchonete, R.drawable.lanchonete, "Sem Ramal", -5.884967, -35.363785));

        listaSetor.add(new Setor("Prédio e-Tec", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.etec, R.string.setor_descricao_predio_etec, R.drawable.etec, "Ramal 224", -5.885260, -35.366496));

        listaSetor.add(new Setor("Restaurante universitário - RU", R.string.horario, R.string.email_reponsavel, R.string.nome_responsavel,
                R.mipmap.ru, R.string.setor_descricao_ru, R.drawable.ru, "Ramal 219", -5.885471, -35.362908));

//        listaSetor.add(new Setor("Bovinocultura", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.ru_round, R.string.setor_descricao_ru, R.drawable.eaj, "(84)43342-2297 ou Ramal 208", -5.885471, -35.362908));
//
//        listaSetor.add(new Setor("Enfermaria", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.etec_round, R.string.setor_descricao_ru, R.drawable.eaj, "(84)43342-2297 ou Ramal 219", -5.885471, -35.362908));

//        listaSetor.add(new Setor("Agropecuaria", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.pecu_agro, R.string.setor_descricao_ru, R.drawable.eaj, "(84)43342-2297 ou Ramal 217", -5.885471, -35.362908));
//
//        listaSetor.add(new Setor("Agroindustria", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.pecu_agro_round, R.string.setor_descricao_ru, R.drawable.eaj, "(84)43342-2297 ou Ramal 218", -5.885471, -35.362908));

//        listaSetor.add(new Setor("UAE", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.etec_round, R.string.setor_descricao_ru, R.drawable.eaj, "(84)43342-2297 ou Ramal 219", -5.885471, -35.362908));
//
//        listaSetor.add(new Setor("Alojamento Masculino", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.aloj_masc_round, R.string.setor_descricao_ru, R.drawable.aloj_mas, "(84)43342-2297", -5.885471, -35.362908));
//
//        listaSetor.add(new Setor("Alojamento Feminino", R.string.horario, "email@responsável.com", "Desconhecido",
//                R.mipmap.aloj_femi_round, R.string.setor_descricao_ru, R.drawable.aloja_fem, "(84)43342-2297", -5.885471, -35.362908));

        return listaSetor;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

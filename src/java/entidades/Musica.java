package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "musica")
@SequenceGenerator(name="seq_musica",
        sequenceName="musica_id_seq",allocationSize=1)

public class Musica {
    
    @Id
   // @Column(name="nameBanco")
    @GeneratedValue(generator = "seq_musica", 
            strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String genero;
    private String duracao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

}
package entidades;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "produto")
@SequenceGenerator(name="seq_produto",
        sequenceName="produto_id_seq",allocationSize=1)

public class Produto {
    
    @Id
   // @Column(name="nameBanco")
    @GeneratedValue(generator = "seq_produto", 
            strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String quantidade;
    private String medidaPeso;
    private String peso;

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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedidaPeso() {
        return medidaPeso;
    }

    public void setMedidaPeso(String medidaPeso) {
        this.medidaPeso = medidaPeso;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

 
}
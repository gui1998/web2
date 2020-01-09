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
@Table(name = "veiculo")
@SequenceGenerator(name="seq_veiculo",
        sequenceName="veiculo_id_seq",allocationSize=1)

public class Veiculo {
    
    @Id
   // @Column(name="nameBanco")
    @GeneratedValue(generator = "seq_veiculo", 
            strategy = GenerationType.SEQUENCE)
    private int id;
    private String placa;
    private String modelo;
    private String marca;
    private String cor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    

}
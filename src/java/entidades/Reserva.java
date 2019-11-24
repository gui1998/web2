package entidades;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "reserva")
@SequenceGenerator(name = "seq_reserva",
        sequenceName = "reserva_id_seq", allocationSize = 1)

public class Reserva {

    @Id
    // @Column(name="nameBanco")
    @GeneratedValue(generator = "seq_reserva",
            strategy = GenerationType.SEQUENCE)
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datareserva;
    private String nomecompleto;
    private String nomepet;
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatareserva() {
        return datareserva;
    }

    public void setDatareserva(Date datareserva) {
        this.datareserva = datareserva;
    }


    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getNomepet() {
        return nomepet;
    }

    public void setNomepet(String nomepet) {
        this.nomepet = nomepet;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}

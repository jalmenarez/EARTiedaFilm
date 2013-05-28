package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;



@Entity
@Table(name="APP.FILMS")
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="IDFILM")
    private int id;
    @Size(max = 50)
    @Column(name="NOMBREFILM")
    private String name;
    @Column(name="DIRECTORFILM")
    private String autor;
    
    public Film(){
        this.id = 0;
        this.name = "";
        this.autor = "";
    }

    public Film(int id, String name, String autor) {
        this.id = id;
        this.name = name;
        this.autor = autor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setId(String id){
        if(!id.isEmpty()){
            try {
             this.id = Integer.valueOf(id);
            }catch(RuntimeException e){
                this.id = 0;
            }
        }else{
            this.id = 0;
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString(){
        StringBuilder sObj = new StringBuilder();
        sObj.append(" ID = ");
        sObj.append(this.id);
        sObj.append(", NAME = ");
        sObj.append(this.name);
        sObj.append(", AUTOR = ");
        sObj.append(this.autor);
        return sObj.toString();
    }

    public boolean validar() {
        if(!this.autor.isEmpty() && !this.name.isEmpty() && this.id != 0){
          return true;  
        }else {
          return false;  
        }
    }    

    public boolean isValid() {
        return !this.autor.isEmpty() && this.id > 0 && !this.name.isEmpty();
    }
}

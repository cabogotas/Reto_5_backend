package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int categoriaId){
        return metodosCrud.getCategoria(categoriaId);
    }

    public Categoria save(Categoria categoria){
        if(categoria.getId()==null){
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if(categoria1.isEmpty()){
                return metodosCrud.save(categoria);
            } else{
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria> gvt=metodosCrud.getCategoria((categoria.getId()));
            if(gvt.isPresent()){
                if(categoria.getDescription()!=null){
                    gvt.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    gvt.get().setName(categoria.getName());
                }
                return metodosCrud.save(gvt.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}

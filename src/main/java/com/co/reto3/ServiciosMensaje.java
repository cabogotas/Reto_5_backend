package com.co.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosMensaje {

    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId){
        return metodosCrud.getMensaje(messageId);
    }

    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> evt=metodosCrud.getMensaje(message.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(message);
            } else{
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> evt=metodosCrud.getMensaje(message.getIdMessage());
            if(evt.isPresent()){
                if(message.getMessageText()!=null){
                    evt.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            } else{
                return message;
            }
        } else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(message ->{
            metodosCrud.delete(message);
            return true;
        } ).orElse(false);
        return aBoolean;
    }
}

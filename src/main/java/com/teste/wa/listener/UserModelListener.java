package com.teste.wa.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.teste.wa.model.Usuario;
import com.teste.wa.service.SequenceGeneratorService;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Component
public class UserModelListener extends AbstractMongoEventListener {

    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent event) {
        if (((Usuario) event.getSource()).getId() < 1) {
            ((Usuario) event.getSource()).setId(sequenceGeneratorService.generateSequence(Usuario.SEQUENCE_NAME));
        }
    }
}
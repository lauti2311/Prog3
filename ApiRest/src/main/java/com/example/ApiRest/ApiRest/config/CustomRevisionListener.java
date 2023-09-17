package com.example.ApiRest.ApiRest.config;

import com.example.ApiRest.ApiRest.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){ final Revision revision = (Revision) revisionEntity;}
}

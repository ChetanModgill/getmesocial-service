package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.FirebaseUser;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {





    public FirebaseUser authentication(String idToken) throws IOException, FirebaseAuthException {
        String uid = FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
        String email = FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();
        String name = FirebaseAuth.getInstance().verifyIdToken(idToken).getName();

        return new FirebaseUser(uid, name, email);
    }
}

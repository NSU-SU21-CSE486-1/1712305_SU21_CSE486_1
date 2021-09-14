package com.hmtsoft.uniclubz.dependencyInjection;

import com.google.firebase.auth.FirebaseUser;

public class FirebaseUserHolder {

    private FirebaseUser firebaseUser;

    public FirebaseUserHolder(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }
}

package com.daniel.starwars.Presenter;

import android.os.Bundle;
import android.view.View;

import com.daniel.starwars.Model.Planet;
import com.daniel.starwars.Model.SWCharacter;

public class DetailsActivityPresenter {
    private View view;
    public DetailsActivityPresenter(DetailsActivityPresenter.View view) {
        this.view = view;
    }

    public void setupCharacterDetails(Bundle bundle){
        if(bundle != null) {
            SWCharacter character = (SWCharacter) bundle.getSerializable("item");
            view.setupCharacterView(character);
        }
    }
    public void setupPlanetDetails(Bundle bundle){
        if(bundle != null) {
            Planet planet = (Planet) bundle.getSerializable("item");
            view.setupPlanetView(planet);
        }
    }
    public interface View{
        void setupCharacterView(SWCharacter character);
        void setupPlanetView(Planet planet);

    }
}

package com.certant.pokedexlite;

import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Type;

import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PokedexLiteApplication {
    private static final Logger logger = Logger.getLogger(PokedexLiteApplication.class);
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        SessionFactory sessionFactory = (SessionFactory)context.getBean("hibernate5LocalSessionFactoryBean");

        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();        
        
        //Types
        Type tp1 = new Type();
        tp1.setName("Normal");
        
        Type tp2 = new Type();
        tp2.setName("Fire");
        
        Type tp3 = new Type();
        tp3.setName("Water");
        
        Type tp4 = new Type();
        tp4.setName("Electric");
        
        Type tp5 = new Type();
        tp5.setName("Grass");
        
        Type tp6 = new Type();
        tp6.setName("Ice");
        
        Type tp7 = new Type();
        tp7.setName("Fighting");
        
        Type tp8 = new Type();
        tp8.setName("Poison");
        
        Type tp9 = new Type();
        tp9.setName("Ground");
        
        Type tp10 = new Type();
        tp10.setName("Flying");
        
        Type tp11 = new Type();
        tp11.setName("Psychic");
        
        Type tp12 = new Type();
        tp12.setName("Bug");
        
        Type tp13 = new Type();
        tp13.setName("Rock");
        
        Type tp14 = new Type();
        tp14.setName("Ghost");
        
        Type tp15 = new Type();
        tp15.setName("Dragon");
        
        Type tp16 = new Type();
        tp16.setName("Dark");
        
        Type tp17 = new Type();
        tp17.setName("Steel");
        
        Type tp18 = new Type();
        tp18.setName("Fairy");
        
        s.save(tp1);
        s.save(tp2);
        s.save(tp3);
        s.save(tp4);
        s.save(tp5);
        s.save(tp6);
        s.save(tp7);
        s.save(tp8);
        s.save(tp9);
        s.save(tp10);
        s.save(tp11);
        s.save(tp12);
        s.save(tp13);
        s.save(tp14);
        s.save(tp15);
        s.save(tp16);
        s.save(tp17);
        s.save(tp18);
        
        //Abilities
        Ability ay1 = new Ability();
        ay1.setName("Overgrow");
        
        Ability ay2 = new Ability();
        ay2.setName("Chlorophyll");

        Ability ay3 = new Ability();
        ay3.setName("Blaze");

        Ability ay4 = new Ability();
        ay4.setName("Solar Power");

        Ability ay5 = new Ability();
        ay5.setName("Torrent");

        Ability ay6 = new Ability();
        ay6.setName("Rain Dish");

        Ability ay7 = new Ability();
        ay7.setName("Shield Dust");

        Ability ay8 = new Ability();
        ay8.setName("Run Away");

        Ability ay9 = new Ability();
        ay9.setName("Keen Eye");

        Ability ay10 = new Ability();
        ay10.setName("Tangled Feet");

        Ability ay11 = new Ability();
        ay11.setName("Guts");

        Ability ay12 = new Ability();
        ay12.setName("Hustle");    

        Ability ay13 = new Ability();
        ay13.setName("Sniper");    

        Ability ay14 = new Ability();
        ay14.setName("Intimidate");    

        Ability ay15 = new Ability();
        ay15.setName("Shed Skin");    

        Ability ay16 = new Ability();
        ay16.setName("Unnerve");    

        Ability ay17 = new Ability();
        ay17.setName("Sand Veil");    

        Ability ay18 = new Ability();
        ay18.setName("Sand Rush");
        
        Ability ay19 = new Ability();
        ay19.setName("Effect Spore"); 
        
        Ability ay20 = new Ability();
        ay20.setName("Dry Skin");
        
        Ability ay21 = new Ability();
        ay21.setName("Damp");

        s.save(ay1);
        s.save(ay2);
        s.save(ay3);
        s.save(ay4);
        s.save(ay5);
        s.save(ay6);
        s.save(ay7);
        s.save(ay8);
        s.save(ay9);
        s.save(ay10);
        s.save(ay11);
        s.save(ay12);
        s.save(ay13);
        s.save(ay14);
        s.save(ay15);
        s.save(ay16);
        s.save(ay17);
        s.save(ay18);
        s.save(ay19);
        s.save(ay20);
        s.save(ay21);
        
        //Pokemons
        Pokemon pk1 = new Pokemon();
        pk1.setName("Bulbasaur");
        pk1.setLevelIsFound(4);
        
        Pokemon pk2 = new Pokemon();
        pk2.setName("Charmander");
        pk2.setLevelIsFound(1);
        
        Pokemon pk3 = new Pokemon();
        pk3.setName("Squirtle");
        pk3.setLevelIsFound(10);
        
        Pokemon pk4 = new Pokemon();
        pk4.setName("Caterpie");
        pk4.setLevelIsFound(2);
        
        Pokemon pk5 = new Pokemon();
        pk5.setName("Weedle");
        pk5.setLevelIsFound(6);
        
        Pokemon pk6 = new Pokemon();
        pk6.setName("Pidgey");
        pk6.setLevelIsFound(6);
        
        Pokemon pk7 = new Pokemon();
        pk7.setName("Rattata");
        pk7.setLevelIsFound(15);
        
        Pokemon pk8 = new Pokemon();
        pk8.setName("Spearow");
        pk8.setLevelIsFound(13);
        
        Pokemon pk9 = new Pokemon();
        pk9.setName("Ekans");
        pk9.setLevelIsFound(21);
        
        Pokemon pk10 = new Pokemon();
        pk10.setName("Sandshrew");
        pk10.setLevelIsFound(19);
        
        Pokemon pk11= new Pokemon();
        pk11.setName("Paras");
        pk11.setLevelIsFound(2);

        s.save(pk1);
        s.save(pk2);
        s.save(pk3);
        s.save(pk4);
        s.save(pk5);
        s.save(pk6);
        s.save(pk7);
        s.save(pk8);
        s.save(pk9);
        s.save(pk10);
        s.save(pk11);
        
        //Evolutions
        Evolution ev1 = new Evolution();
        ev1.setName("Ivysaur");
        ev1.setLevelNeeded(16);
        
        Evolution ev2 = new Evolution();
        ev2.setName("Venusaur");
        ev2.setLevelNeeded(32);

        Evolution ev3 = new Evolution();
        ev3.setName("Charmeleon");
        ev3.setLevelNeeded(16);
        
        Evolution ev4 = new Evolution();
        ev4.setName("Charizard");
        ev4.setLevelNeeded(36);         

        Evolution ev5 = new Evolution();
        ev5.setName("Wartortle");
        ev5.setLevelNeeded(16);
        
        Evolution ev6 = new Evolution();
        ev6.setName("Blastoise");
        ev6.setLevelNeeded(36);

        Evolution ev7 = new Evolution();
        ev7.setName("Metapod");
        ev7.setLevelNeeded(7);
        
        Evolution ev8 = new Evolution();
        ev8.setName("Butterfree");
        ev8.setLevelNeeded(10);         

        Evolution ev9 = new Evolution();
        ev9.setName("Kakuna");
        ev9.setLevelNeeded(7);
        
        Evolution ev10 = new Evolution();
        ev10.setName("Beedrill");
        ev10.setLevelNeeded(10);

        Evolution ev11 = new Evolution();
        ev11.setName("Pidgeotto");
        ev11.setLevelNeeded(18);
        
        Evolution ev12 = new Evolution();
        ev12.setName("Pidgeot");
        ev12.setLevelNeeded(36);         

        Evolution ev13 = new Evolution();
        ev13.setName("Raticate");
        ev13.setLevelNeeded(20);
        
        Evolution ev14 = new Evolution();
        ev14.setName("Fearow");
        ev14.setLevelNeeded(20);

        Evolution ev15 = new Evolution();
        ev15.setName("Arbok");
        ev15.setLevelNeeded(22);
        
        Evolution ev16 = new Evolution();
        ev16.setName("Sandslash");
        ev16.setLevelNeeded(22);

        Evolution ev17 = new Evolution();
        ev17.setName("Parasect");
        ev17.setLevelNeeded(24);
        
        s.save(ev1);
        s.save(ev2);
        s.save(ev3);
        s.save(ev4);
        s.save(ev5);
        s.save(ev6);
        s.save(ev7);
        s.save(ev8);
        s.save(ev9);
        s.save(ev10);
        s.save(ev11);
        s.save(ev12);
        s.save(ev13);
        s.save(ev14);
        s.save(ev15);
        s.save(ev16);
        s.save(ev17);
        
        //Relations
        //Pokemon01     
        pk1.addAbility(ay1);
        pk1.addAbility(ay2);
        pk1.addType(tp5);
        pk1.addType(tp8);
        pk1.addEvolution(ev1);
        pk1.addEvolution(ev2);
        s.update(pk1);
        
        ay1.addPokemon(pk1);
        ay2.addPokemon(pk1);
        s.update(ay1);
        s.update(ay2);
        
        tp5.addPokemon(pk1);
        tp8.addPokemon(pk1);
        s.update(tp5);
        s.update(tp8);
        
        ev1.setPokemon(pk1);
        ev1.addType(tp5);
        ev1.addType(tp8);
        s.update(ev1);
        
        ev2.setPokemon(pk1);
        ev2.addType(tp5);
        ev2.addType(tp8);
        s.update(ev2);
        
        tp5.addEvolution(ev1);
        tp5.addEvolution(ev2);
        s.update(tp5);
        
        tp8.addEvolution(ev1);
        tp8.addEvolution(ev2);
        s.update(tp8);
        
        //Pokemon02
        pk2.addAbility(ay3);
        pk2.addAbility(ay4);
        pk2.addType(tp2);
        pk2.addEvolution(ev3);
        pk2.addEvolution(ev4);
        s.update(pk2);
        
        ay3.addPokemon(pk2);
        ay4.addPokemon(pk2);
        s.update(ay3);
        s.update(ay4);
        
        tp2.addPokemon(pk2);
        s.update(tp2);
        
        ev3.setPokemon(pk2);
        ev3.addType(tp2);
        s.update(ev3);
        
        ev4.setPokemon(pk2);
        ev4.addType(tp2);
        s.update(ev4);
        
        tp2.addEvolution(ev3);
        tp2.addEvolution(ev4);
        s.update(tp2);
        
        //Pokemon03
        pk3.addAbility(ay5);
        pk3.addAbility(ay6);
        pk3.addType(tp3);
        pk3.addEvolution(ev5);
        pk3.addEvolution(ev6);
        s.update(pk3);
        
        ay5.addPokemon(pk3);
        ay6.addPokemon(pk3);
        s.update(ay5);
        s.update(ay6);
        
        tp3.addPokemon(pk3);
        s.update(tp3);
        
        ev5.setPokemon(pk3);
        ev5.addType(tp3);
        s.update(ev5);
        
        ev6.setPokemon(pk3);
        ev6.addType(tp3);
        s.update(ev6);
        
        tp3.addEvolution(ev5);
        tp3.addEvolution(ev6);
        s.update(tp3);
        
        //Pokemon04
        pk4.addAbility(ay7);
        pk4.addAbility(ay8);
        pk4.addType(tp12);
        pk4.addEvolution(ev7);
        pk4.addEvolution(ev8);
        s.update(pk4);
        
        ay7.addPokemon(pk4);
        ay8.addPokemon(pk5);
        s.update(ay7);
        s.update(ay8);
        
        tp12.addPokemon(pk4);
        s.update(tp12);
        
        ev7.setPokemon(pk4);
        ev7.addType(tp12);
        s.update(ev7);
        
        ev8.setPokemon(pk4);
        ev8.addType(tp10);
        ev8.addType(tp12);
        s.update(ev8);
        
        tp12.addEvolution(ev7);
        tp12.addEvolution(ev8);
        s.update(tp12);
        
        tp10.addEvolution(ev8);
        s.update(tp10);
        
        //Pokemon05
        pk5.addAbility(ay7);
        pk5.addAbility(ay8);
        pk5.addType(tp8);
        pk5.addType(tp12);
        pk5.addEvolution(ev9);
        pk5.addEvolution(ev10);
        s.update(pk5);
        
        ay7.addPokemon(pk5);
        ay8.addPokemon(pk5);
        s.update(ay7);
        s.update(ay8);
        
        tp8.addPokemon(pk5);
        s.update(tp8);        
        
        tp12.addPokemon(pk5);
        s.update(tp12);
        
        ev9.setPokemon(pk5);
        ev9.addType(tp8);
        ev9.addType(tp12);
        s.update(ev9);
        
        ev10.setPokemon(pk5);
        ev10.addType(tp8);
        ev10.addType(tp12);
        s.update(ev10);
        
        tp8.addEvolution(ev9);
        tp8.addEvolution(ev10);
        s.update(tp8);        
        
        tp12.addEvolution(ev9);
        tp12.addEvolution(ev10);
        s.update(tp12);
        
        //Pokemon06
        pk6.addAbility(ay9);
        pk6.addAbility(ay10);
        pk6.addType(tp1);
        pk6.addType(tp10);
        pk6.addEvolution(ev11);
        pk6.addEvolution(ev12);
        s.update(pk6);
        
        ay9.addPokemon(pk6);
        ay10.addPokemon(pk6);
        s.update(ay9);
        s.update(ay10);
        
        tp1.addPokemon(pk6);
        s.update(tp1);
        
        tp10.addPokemon(pk6);
        s.update(tp10);
        
        ev11.setPokemon(pk6);
        ev11.addType(tp1);
        ev11.addType(tp10);
        s.update(ev11);
        
        ev12.setPokemon(pk6);
        ev12.addType(tp1);
        ev12.addType(tp10);
        s.update(ev12);
        
        tp1.addEvolution(ev11);
        tp1.addEvolution(ev12);
        s.update(tp1);
        
        tp10.addEvolution(ev11);
        tp10.addEvolution(ev12);
        s.update(tp10);

        //Pokemon07
        pk7.addAbility(ay8);
        pk7.addAbility(ay11);
        pk7.addAbility(ay12);
        pk7.addType(tp1);
        pk7.addEvolution(ev13);
        s.update(pk7);
        
        ay8.addPokemon(pk7);
        ay11.addPokemon(pk7);
        ay12.addPokemon(pk7);
        s.update(ay8);
        s.update(ay11);
        s.update(ay12);
        
        tp1.addPokemon(pk7);
        s.update(tp1);
        
        ev13.setPokemon(pk7);
        ev13.addType(tp1);
        s.update(ev13);
        
        tp1.addEvolution(ev13);
        s.update(tp1);
        
        //Pokemon08
        pk8.addAbility(ay9);
        pk8.addAbility(ay13);
        pk8.addType(tp1);
        pk8.addType(tp10);
        pk8.addEvolution(ev14);
        s.update(pk8);
        
        ay9.addPokemon(pk8);
        ay13.addPokemon(pk8);
        s.update(ay9);
        s.update(ay13);
        
        tp1.addPokemon(pk8);
        s.update(tp1);
        
        tp10.addPokemon(pk8);
        s.update(tp10);
        
        ev14.setPokemon(pk8);
        ev14.addType(tp1);
        ev14.addType(tp10);
        s.update(ev14);
        
        tp1.addEvolution(ev14);
        s.update(tp1);
        
        tp10.addEvolution(ev14);
        s.update(tp10);
        
        //Pokemon09
        pk9.addAbility(ay14);
        pk9.addAbility(ay15);
        pk9.addAbility(ay16);
        pk9.addType(tp8);
        pk9.addEvolution(ev15);
        s.update(pk9);
        
        ay14.addPokemon(pk9);
        ay15.addPokemon(pk9);
        ay16.addPokemon(pk9);
        s.update(ay14);
        s.update(ay15);
        s.update(ay16);
        
        tp8.addPokemon(pk9);
        s.update(tp8);
        
        ev15.setPokemon(pk9);
        ev15.addType(tp8);
        s.update(ev15);
        
        tp8.addEvolution(ev15);
        s.update(tp8);
        
        //Pokemon10
        pk10.addAbility(ay17);
        pk10.addAbility(ay18);
        pk10.addType(tp9);
        pk10.addEvolution(ev16);
        s.update(pk10);
        
        ay17.addPokemon(pk10);
        ay18.addPokemon(pk10);
        s.update(ay17);
        s.update(ay18);
        
        tp9.addPokemon(pk10);
        s.update(tp9);
        
        ev16.setPokemon(pk10);
        ev16.addType(tp9);
        s.update(ev16);
        
        tp9.addEvolution(ev16);
        s.update(tp9);
        
        //Pokemon11
        pk11.addAbility(ay19);
        pk11.addAbility(ay20);
        pk11.addAbility(ay21);
        pk11.addType(tp5);
        pk11.addType(tp12);
        pk11.addEvolution(ev17);
        s.update(pk11);
        
        ay19.addPokemon(pk11);
        ay20.addPokemon(pk11);
        ay21.addPokemon(pk11);
        s.update(ay19);
        s.update(ay20);
        s.update(ay21);
        
        tp12.addPokemon(pk11);
        s.update(tp12);
        
        tp5.addPokemon(pk11);
        s.update(tp5);
        
        ev17.setPokemon(pk11);
        ev17.addType(tp5);
        ev17.addType(tp12);
        s.update(ev17);
        
        tp5.addEvolution(ev17);
        s.update(tp5);        
        
        tp12.addEvolution(ev17);
        s.update(tp12);
        
        t.commit();
        s.close();        
    }
}
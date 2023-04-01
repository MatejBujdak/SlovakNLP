package sk.textprocessor.processing;

public class Abbreviation {
    String[] abbreviations_dictionary = {
            "bc.", "icdr.", "ing.", "arch.", "napr.", "judr.", "art.", "arch.", "mgr.", "mddr.", "mudr.",
            "mvdr.", "paeddr.", "pharmdr.", "phdr.", "phmr.", "rndr.", "rsdr.", "rtdr.", "thdr.", "thlic.",
            "artd.", "csc.", "drsc.", "ph.d.", "th.d.", "doc.", "prof.", "dr. h. c.", "slob.", "des.", "čat.",
            "rt.", "rtm.", "nrtm.", "šbnrtm.", "pprap.", "prap.", "nprap.", "ppor.", "por.", "npor.", "kpt.",
            "mjr.", "pplk.", "plk.", "brig. gen.", "genmjr.", "genpor.", "arm. gen.", "gen.", "akuz.", "admin.",
            "afr.", "al.", "amer.", "anat.", "angl.", "anorg.", "ap.", "arab.", "arch.", "archeol.", "archit.",
            "astron.", "atď.", "aut.", "ázij.", "ban.", "bezpredm.", "bibl.", "biol.", "bot.", "bud.", "burž.", "býv.",
            "cirk.", "cit.", "cukrár.", "cukrovar.", "č.", "čast.", "čes.", "čísl.", "číslov.", "čs.", "D, dat.", "defekt.",
            "det.", "dipl.", "div.", "distrib.", "dok.", "dopr.", "dram.", "druh.", "duš.","dvojčl.", "ekol.", "ekon.",
            "elektr.", "elektrotech.", "energet.", "est.", "eur.", "ev.", "expr.", "fam.", "farm.", "feud.", "filat.",
            "film.", "filol.", "filoz.", "fin.", "fín.", "fon.", "fot.", "franc.", "fraz.", "fyz.", "fyziol.",
            "gen.", "garb.", "genet.", "geod.", "geogr.", "geol.", "geom.", "graf.","gréc.", "gréckokat.", "gram.",
            "hebr.", "hist.", "hl.", "hod.", "hosp.", "hovor.", "hromad.", "hrub.", "hud.", "hut.", "hyd.", "hypok.",
            "chem.", "chorv.", "inštr.", "inf.", "inform.", "ind.", "iron.",
            "jap.", "jedn.", "juhoamer.", "juhových.", "juhozáp.", "juž.", "kapit.", "kart.", "kat.",
            "ker.", "knih.", "kniž.", "kozmet.", "kraj.", "krajč.", "kresť.", "kt.", "kuch.", "kult.", "lok.",
            "lat.", "latinskoamer.", "lek.", "les.", "let.", "lingv.", "lit.", "log.", "ľud.", "m.", "maď.", "mal.",
            "mat.", "medzinár.", "mech.", "meteor.", "metr.", "mil.", "min.", "miner.", "mn.", "č.",
            "motor.", "muž.", "mytol.", "ped.", "pejor.", "peňaž.", "pís.", "pl.", "plat.", "Kr.", "pod.", "podm.",
            "podraď.", "podst.", "podst.", "poet.", "poľ.", "polit.", "politol.", "poľnohosp.", "poľov.", "polygr.",
            "pomn.", "porov.", "pošt.", "potrav.", "použ.", "nom.", "náb.", "napr.", "nár.", "nás.", "naznač.", "nedok.",
            "nem.", "neodb.", "neos.", "neskl.", "nespis.", "nespráv.", "neurč.", "neved.", "neživ.", "niekt.",
            "niž. hovor.", "n.l.", "obch.", "obuv.", "obyč.", "odb.", "odkaz.", "op.", "opak.", "opt.", "opyt.",
            "org.", "os.", "oslab.", "osob.", "ovoc.", "označ.", "oznam.", "oznam.", "tech.", "r.", "rad.",
            "rádiotech.", "reč.", "resp.", "rím.", "rob.", "róm.", "rozhlas.", "rozk.", "rozlič.", "rozpráv.",
            "rumun.", "rus.", "ryb.", "s.", "sev.", "severoamer.", "skr.", "sg.", "skup.", "slang.", "sloven.",
            "soc.", "sociol.", "soch.", "sov.", "spis.", "spoj.", "spoloč.", "spôs.", "správ.", "srb.", "st.",
            "star.", "starogréc.", "starorím.", "stav.", "stol.", "stor.", "stred.,", "str.", "stredoamer.",
            "stredoškol.", "stroj.", "subšt.", "súvzť.", "svet.", "sv.", "šach.", "škol.", "špan.", "šport.",
            "št.", "štud.", "štyl.", "švéd.", "tal.", "tech.", "tel.", "teles.", "telef.", "telev.", "text.",
            "tur.", "turist.", "typ.", "tzv.", "účt.", "ukaz.", "umel.", "urč.", "úr.", "vok.", "včel.", "ved.",
            "vedľ.", "ver.", "veter.", "vin.", "vodohosp.", "voj.", "v spoj.", "všeob.", "vulg.", "vých.", "vyj.",
            "vymedz.", "výr.", "vys.", "výsl.", "vysokoškol.", "výtvar.", "význ.", "vzťaž.", "záhr.", "zákl.", "zám.",
            "záp.", "západoeur.", "zápor.", "zastar.", "zastaráv.", "zdrav.", "zdrob.", "zjemn.", "zlat.", "zlom.",
            "zn.", "zool.", "zried.", "zv.", "zvel.", "zvol.", "zvrat.", "ž.", "žart.", "žel.", "žen.", "žid.", "živ."

    };

    public boolean isAbbreviation(String word) {
        for (String s : abbreviations_dictionary) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }



}


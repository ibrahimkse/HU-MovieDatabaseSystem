import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // arg commands
        String peopleString = args[0];
        String filmString = args[1];
        String commandString = args[2];
        String outputString = args[3];

        // reading all the files
        ReadFromFile readFromFile = new ReadFromFile();
        File peopleFile = readFromFile.openFile(peopleString);
        File filmFile = readFromFile.openFile(filmString);
        File commandFile = readFromFile.openFile(commandString);
        File outputFile = readFromFile.openFile(outputString);
        ArrayList<String> peopleArrayList = readFromFile.readFile(peopleFile);
        ArrayList<String> filmArrayList = readFromFile.readFile(filmFile);
        ArrayList<String> commandArrayList = readFromFile.readFile(commandFile);

        // arraylists that includes objects
        ArrayList<Director> directors = new ArrayList<>();
        ArrayList<Writer> writers = new ArrayList<>();
        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<ChildActor> childActors = new ArrayList<>();
        ArrayList<StuntPerformer> stuntPerformers = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        // this for loop's purpose --> creating objects from people.txt
        for (String peopleLine : peopleArrayList){
            ArrayList<String> plArraylist = new ArrayList<>();
            for (String piece : peopleLine.split("\t")){
                plArraylist.add(piece);
            }
            if (plArraylist.get(0).equals("Director:")){
                directors.add(new Director(plArraylist.get(1), plArraylist.get(2), plArraylist.get(3),
                        plArraylist.get(4), plArraylist.get(5)));
            }
            else if (plArraylist.get(0).equals("Writer:")){
                writers.add(new Writer(plArraylist.get(1), plArraylist.get(2), plArraylist.get(3),
                        plArraylist.get(4), plArraylist.get(5)));
            }
            else if (plArraylist.get(0).equals("Actor:")){
                actors.add(new Actor(plArraylist.get(1), plArraylist.get(2), plArraylist.get(3),
                        plArraylist.get(4), plArraylist.get(5)));
            }
            else if (plArraylist.get(0).equals("ChildActor:")){
                childActors.add(new ChildActor(plArraylist.get(1), plArraylist.get(2), plArraylist.get(3),
                        plArraylist.get(4), plArraylist.get(5)));
            }
            else if (plArraylist.get(0).equals("StuntPerformer:")){
                ArrayList<String> spIds = new ArrayList<>();
                for (String piece : plArraylist.get(6).split(",")){
                    spIds.add(piece);
                }
                stuntPerformers.add(new StuntPerformer(plArraylist.get(1), plArraylist.get(2), plArraylist.get(3),
                        plArraylist.get(4), plArraylist.get(5), spIds));
            }
            else if (plArraylist.get(0).equals("User:")){
                users.add(new User(plArraylist.get(1), plArraylist.get(2), plArraylist.get(3),
                        plArraylist.get(4)));
            }
        }

        //arraylist for all performer Id's
        ArrayList<String> allPerformers = new ArrayList<>();
        for (Actor actor : actors){
            allPerformers.add(actor.getId());
        }
        for (ChildActor childActor : childActors){
            allPerformers.add(childActor.getId());
        }
        for (StuntPerformer sp : stuntPerformers){
            allPerformers.add(sp.getId());
        }
        //arraylist for director Id's
        ArrayList<String> allDirectors = new ArrayList<>();
        for (Director dir : directors){
            allDirectors.add(dir.getId());
        }
        //arraylist for writers Id's
        ArrayList<String> allWriters = new ArrayList<>();
        for (Writer writer : writers){
            allWriters.add(writer.getId());
        }

        // arraylists that includes film objects
        ArrayList<FeatureFilm> featureFilmObjects = new ArrayList<>();
        ArrayList<ShortFilm> shortFilmObjects = new ArrayList<>();
        ArrayList<Documentary> documentaryObjects = new ArrayList<>();
        ArrayList<TVSeries> tvSeriesObjects = new ArrayList<>();

        // this for loop's purpose --> creating objects from films.txt
        for (String filmLine : filmArrayList){
            ArrayList<String> flArraylist = new ArrayList<>();
            for (String piece : filmLine.split("\t")){
                flArraylist.add(piece);
            }
            if (flArraylist.get(0).equals("FeatureFilm:")){
                ArrayList<String> directorsArr = new ArrayList<>();
                for (String piece : flArraylist.get(4).split(",")){
                    directorsArr.add(piece);
                }
                ArrayList<String> castArr = new ArrayList<>();
                for (String piece : flArraylist.get(7).split(",")){
                    castArr.add(piece);
                }
                ArrayList<String> genreArr = new ArrayList<>();
                for (String piece : flArraylist.get(8).split(",")){
                    genreArr.add(piece);
                }
                ArrayList<String> writersArr = new ArrayList<>();
                for (String piece : flArraylist.get(10).split(",")){
                    writersArr.add(piece);
                }
                featureFilmObjects.add(new FeatureFilm(flArraylist.get(1), flArraylist.get(2), flArraylist.get(3),
                        directorsArr, flArraylist.get(5), flArraylist.get(6), castArr, genreArr, flArraylist.get(9),
                        writersArr, flArraylist.get(11)));
            }
            else if (flArraylist.get(0).equals("ShortFilm:")){
                ArrayList<String> directorsArr = new ArrayList<>();
                for (String piece : flArraylist.get(4).split(",")){
                    directorsArr.add(piece);
                }
                ArrayList<String> castArr = new ArrayList<>();
                for (String piece : flArraylist.get(7).split(",")){
                    castArr.add(piece);
                }
                ArrayList<String> genreArr = new ArrayList<>();
                for (String piece : flArraylist.get(8).split(",")){
                    genreArr.add(piece);
                }
                ArrayList<String> writersArr = new ArrayList<>();
                for (String piece : flArraylist.get(10).split(",")){
                    writersArr.add(piece);
                }
                shortFilmObjects.add(new ShortFilm(flArraylist.get(1), flArraylist.get(2), flArraylist.get(3),
                        directorsArr, flArraylist.get(5), flArraylist.get(6), castArr, genreArr, flArraylist.get(9),
                        writersArr));
            }
            else if (flArraylist.get(0).equals("Documentary:")){
                ArrayList<String> directorsArr = new ArrayList<>();
                for (String piece : flArraylist.get(4).split(",")){
                    directorsArr.add(piece);
                }
                ArrayList<String> castArr = new ArrayList<>();
                for (String piece : flArraylist.get(7).split(",")){
                    castArr.add(piece);
                }
                documentaryObjects.add(new Documentary(flArraylist.get(1), flArraylist.get(2), flArraylist.get(3),
                        directorsArr, flArraylist.get(5), flArraylist.get(6), castArr, flArraylist.get(8)));
            }
            else if (flArraylist.get(0).equals("TVSeries:")){
                ArrayList<String> directorsArr = new ArrayList<>();
                for (String piece : flArraylist.get(4).split(",")){
                    directorsArr.add(piece);
                }
                ArrayList<String> castArr = new ArrayList<>();
                for (String piece : flArraylist.get(7).split(",")){
                    castArr.add(piece);
                }
                ArrayList<String> genreArr = new ArrayList<>();
                for (String piece : flArraylist.get(8).split(",")){
                    genreArr.add(piece);
                }
                ArrayList<String> writersArr = new ArrayList<>();
                for (String piece : flArraylist.get(9).split(",")){
                    writersArr.add(piece);
                }
                tvSeriesObjects.add(new TVSeries(flArraylist.get(1), flArraylist.get(2), flArraylist.get(3),
                        directorsArr, flArraylist.get(5), flArraylist.get(6), castArr, genreArr, writersArr,
                        flArraylist.get(10), flArraylist.get(11), flArraylist.get(12), flArraylist.get(13)));
            }
        }
        //arraylist for FeatureFilm Id's
        ArrayList<String> featureFilmIds = new ArrayList<>();
        for (FeatureFilm ff : featureFilmObjects){
            featureFilmIds.add(ff.getId());
        }
        //arraylist for ShortFilm Id's
        ArrayList<String> shortFilmIds = new ArrayList<>();
        for (ShortFilm sf : shortFilmObjects){
            shortFilmIds.add(sf.getId());
        }
        //arraylist for Documentary Id's
        ArrayList<String> documentaryIds = new ArrayList<>();
        for (Documentary dc : documentaryObjects){
            documentaryIds.add(dc.getId());
        }
        //arraylist for TVSeries Id's
        ArrayList<String> tvSeriesIds = new ArrayList<>();
        for (TVSeries tv : tvSeriesObjects){
            tvSeriesIds.add(tv.getId());
        }
        // arraylist for all films Id's
        ArrayList<String> allFilmIds = new ArrayList<>();
        allFilmIds.addAll(featureFilmIds);
        allFilmIds.addAll(shortFilmIds);
        allFilmIds.addAll(documentaryIds);
        allFilmIds.addAll(tvSeriesIds);


        // for loop for commands
        for (String commandLine : commandArrayList){
            ReadFromFile.writeFile(outputFile, commandLine + "\n");
            ArrayList<String> clArrayList = new ArrayList<>();
            for (String piece : commandLine.split("\t")){
                clArrayList.add(piece);
            }
            if (clArrayList.get(0).equals("ADD")){
                String addId = clArrayList.get(2);
                String addTitle = clArrayList.get(3);
                String addLanguage = clArrayList.get(4);
                ArrayList<String> addDirectors = new ArrayList<>();
                for (String piece : clArrayList.get(5).split(",")){
                    addDirectors.add(piece);
                }
                String addRunTime = clArrayList.get(6);
                String addCountry = clArrayList.get(7);
                ArrayList<String> addCast = new ArrayList<>();
                for (String piece : clArrayList.get(8).split(",")){
                    addCast.add(piece);
                }
                ArrayList<String> addGenre = new ArrayList<>();
                for (String piece : clArrayList.get(9).split(",")){
                    addGenre.add(piece);
                }
                String addReleaseDate = clArrayList.get(10);
                ArrayList<String> addWriters = new ArrayList<>();
                for (String piece : clArrayList.get(11).split(",")){
                    addWriters.add(piece);
                }
                String addBudget = clArrayList.get(12);
                boolean failed = false;
                for (FeatureFilm ff : featureFilmObjects){
                    if (ff.getId().equals(addId)){
                        failed = true;
                        break;
                    }
                    for (String addDir : addDirectors){
                        if (!allDirectors.contains(addDir)){
                            failed = true;
                            break;
                        }
                    }
                    for (String addWri : addWriters){
                        if (!allWriters.contains(addWri)){
                            failed = true;
                            break;
                        }
                    }
                    for (String addCa : addCast){
                       if (!allPerformers.contains(addCa)){
                           failed = true;
                           break;
                       }
                    }
                }
                if (failed){
                    ReadFromFile.writeFile(outputFile, "Command Failed");
                    ReadFromFile.writeFile(outputFile, "Film ID: " + addId);
                    ReadFromFile.writeFile(outputFile, "Film title: " + addTitle);
                }
                else {
                    featureFilmObjects.add(new FeatureFilm(addId, addTitle, addLanguage, addDirectors,
                            addRunTime, addCountry, addCast, addGenre, addReleaseDate, addWriters, addBudget));
                    allFilmIds.add(addId);
                    ReadFromFile.writeFile(outputFile, "FeatureFilm added successfully");
                    ReadFromFile.writeFile(outputFile, "Film ID: " + addId);
                    ReadFromFile.writeFile(outputFile, "Film title: " + addTitle);
                }
            }
            if (clArrayList.get(0).equals("RATE")){
                String rateUserId = clArrayList.get(1);
                String rateFilmId = clArrayList.get(2);
                String ratingOfUser = clArrayList.get(3);
                boolean isUserIdCorrect = false;
                boolean isFilmIdCorrect = false;
                for (User user : users){
                    if (user.getId().equals(rateUserId)){
                        isUserIdCorrect = true;
                    }
                }
                for (String id : allFilmIds){
                    if (id.equals(rateFilmId)){
                        isFilmIdCorrect = true;
                    }
                }
                if (!isUserIdCorrect || !isFilmIdCorrect){
                    ReadFromFile.writeFile(outputFile, "Command Failed");
                    ReadFromFile.writeFile(outputFile, "User ID: " + rateUserId);
                    ReadFromFile.writeFile(outputFile, "Film ID: " + rateFilmId);
                }
                else{
                    for (User user : users){
                        if (user.getId().equals(rateUserId)){
                            for (FeatureFilm ff : featureFilmObjects){
                                if (ff.getId().equals(rateFilmId)){
                                    if (user.isEarlierRated(user, rateFilmId)){
                                        ReadFromFile.writeFile(outputFile, "This film was earlier rated");
                                    }
                                    else{
                                        user.addRateToUserHashMap(user, rateFilmId, ratingOfUser);
                                        ff.filmHashMap.put(rateUserId, ratingOfUser);
                                        ReadFromFile.writeFile(outputFile, "Film rated successfully");
                                        ReadFromFile.writeFile(outputFile, "Film type: " + "FeatureFilm");
                                        ReadFromFile.writeFile(outputFile, "Film title: " + ff.getTitle());
                                    }
                                }
                            }
                            for (ShortFilm sf : shortFilmObjects){
                                if (sf.getId().equals(rateFilmId)){
                                    if (user.isEarlierRated(user, rateFilmId)){
                                        ReadFromFile.writeFile(outputFile, "This film was earlier rated");
                                    }
                                    else{
                                        user.addRateToUserHashMap(user, rateFilmId, ratingOfUser);
                                        sf.filmHashMap.put(rateUserId, ratingOfUser);
                                        ReadFromFile.writeFile(outputFile, "Film rated successfully");
                                        ReadFromFile.writeFile(outputFile, "Film type: " + "ShortFilm");
                                        ReadFromFile.writeFile(outputFile, "Film title: " + sf.getTitle());
                                    }
                                }
                            }
                            for (Documentary documentary : documentaryObjects){
                                if (documentary.getId().equals(rateFilmId)){
                                    if (user.isEarlierRated(user, rateFilmId)){
                                        ReadFromFile.writeFile(outputFile, "This film was earlier rated");
                                    }
                                    else{
                                        user.addRateToUserHashMap(user, rateFilmId, ratingOfUser);
                                        documentary.filmHashMap.put(rateUserId, ratingOfUser);
                                        ReadFromFile.writeFile(outputFile, "Film rated successfully");
                                        ReadFromFile.writeFile(outputFile, "Film type: " + "Documentary");
                                        ReadFromFile.writeFile(outputFile, "Film title: " + documentary.getTitle());
                                    }
                                }
                            }
                            for (TVSeries tvs : tvSeriesObjects){
                                if (tvs.getId().equals(rateFilmId)){
                                    if (user.isEarlierRated(user, rateFilmId)){
                                        ReadFromFile.writeFile(outputFile, "This film was earlier rated");
                                    }
                                    else{
                                        user.addRateToUserHashMap(user, rateFilmId, ratingOfUser);
                                        tvs.filmHashMap.put(rateUserId, ratingOfUser);
                                        ReadFromFile.writeFile(outputFile, "Film rated successfully");
                                        ReadFromFile.writeFile(outputFile, "Film type: " + "TVSeries");
                                        ReadFromFile.writeFile(outputFile, "Film title: " + tvs.getTitle());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("FILM") && clArrayList.get(2).equals("SERIES")){
                if (tvSeriesObjects.isEmpty()){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
                else {
                    for (TVSeries tvs : tvSeriesObjects){
                        ReadFromFile.writeFile(outputFile, tvs.getTitle() + " (" +
                                tvs.getStartDate().substring(6) + "-" + tvs.getEndDate().substring(6) + ")");
                        ReadFromFile.writeFile(outputFile, tvs.getNumberOfSeasons() + " seasons and " +
                                tvs.getNumberOfEpisodes() + " episodes\n");
                    }
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("FILMS") &&
                    clArrayList.get(2).equals("BY") && clArrayList.get(3).equals("COUNTRY")){
                boolean doesResultExist = false;
                String countryToFind = clArrayList.get(4);
                for (FeatureFilm ff : featureFilmObjects){
                    if (ff.getCountry().equals(countryToFind)){
                        doesResultExist = true;
                        ReadFromFile.writeFile(outputFile, "Film title: " + ff.getTitle());
                        ReadFromFile.writeFile(outputFile, ff.getRunTime() + " min");
                        ReadFromFile.writeFile(outputFile, "Language: " + ff.getLanguage() + "\n");
                    }
                }
                for (ShortFilm sf : shortFilmObjects){
                    if (sf.getCountry().equals(countryToFind)){
                        doesResultExist = true;
                        ReadFromFile.writeFile(outputFile, "Film title: " + sf.getTitle());
                        ReadFromFile.writeFile(outputFile, sf.getRunTime() + " min");
                        ReadFromFile.writeFile(outputFile, "Language: " + sf.getLanguage() + "\n");
                    }
                }
                for (Documentary documentary : documentaryObjects){
                    if (documentary.getCountry().equals(countryToFind)){
                        doesResultExist = true;
                        ReadFromFile.writeFile(outputFile, "Film title: " + documentary.getTitle());
                        ReadFromFile.writeFile(outputFile, documentary.getRunTime() + " min");
                        ReadFromFile.writeFile(outputFile, "Language: " + documentary.getLanguage() + "\n");
                    }
                }
                for (TVSeries tvs : tvSeriesObjects){
                    if (tvs.getCountry().equals(countryToFind)){
                        doesResultExist = true;
                        ReadFromFile.writeFile(outputFile, "Film title: " + tvs.getTitle());
                        ReadFromFile.writeFile(outputFile, tvs.getRunTime() + " min");
                        ReadFromFile.writeFile(outputFile, "Language: " + tvs.getLanguage() + "\n");
                    }
                }
                if (!doesResultExist){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("ARTISTS") &&
                    clArrayList.get(2).equals("FROM")){
                boolean isResultExist = false;
                boolean isResultExist2 = false;
                boolean isResultExist3 = false;
                boolean isResultExist4 = false;
                boolean isResultExist5 = false;
                String countryToFind = clArrayList.get(3);
                ReadFromFile.writeFile(outputFile, "Directors:");
                for (Director director : directors){
                    if (director.getCountry().equals(countryToFind)){
                        isResultExist = true;
                        ReadFromFile.writeFile(outputFile, director.getName() + " " + director.getSurName() +
                                " " + director.getAgent());
                    }
                }
                if (!isResultExist){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
                ReadFromFile.writeFile(outputFile, "");
                ReadFromFile.writeFile(outputFile, "Writers:");
                for (Writer writer : writers){
                    if (writer.getCountry().equals(countryToFind)){
                        isResultExist2 = true;
                        ReadFromFile.writeFile(outputFile, writer.getName() + " " + writer.getSurName() +
                                " " + writer.getWritingStyle());
                    }
                }
                if (!isResultExist2){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
                ReadFromFile.writeFile(outputFile, "");
                ReadFromFile.writeFile(outputFile, "Actors:");
                for (Actor actor : actors){
                    if (actor.getCountry().equals(countryToFind)){
                        isResultExist3 = true;
                        ReadFromFile.writeFile(outputFile, actor.getName() + " " + actor.getSurName() +
                                " " + actor.getHeight() + " cm");
                    }
                }
                if (!isResultExist3){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
                ReadFromFile.writeFile(outputFile, "");
                ReadFromFile.writeFile(outputFile, "ChildActors:");
                for (ChildActor child : childActors){
                    if (child.getCountry().equals(countryToFind)){
                        isResultExist4 = true;
                        ReadFromFile.writeFile(outputFile, child.getName() + " " + child.getSurName() +
                                " " + child.getAge());
                    }
                }
                if (!isResultExist4){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
                ReadFromFile.writeFile(outputFile, "");
                ReadFromFile.writeFile(outputFile, "StuntPerformers:");
                for (StuntPerformer sp : stuntPerformers){
                    if (sp.getCountry().equals(countryToFind)){
                        isResultExist5 = true;
                        ReadFromFile.writeFile(outputFile, sp.getName() + " " + sp.getSurName() +
                                " " + sp.getHeight() + " cm");
                    }
                }
                if (!isResultExist5){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("FEATUREFILMS") &&
                    clArrayList.get(2).equals("BEFORE")){
                String year = clArrayList.get(3);
                int intYear = Integer.parseInt(year);
                boolean doesExist = false;
                for (FeatureFilm ff : featureFilmObjects){
                    String ffYear = ff.getReleaseDate().substring(6);
                    int intFfYear = Integer.parseInt(ffYear);
                    if (intYear > intFfYear){
                        doesExist = true;
                        ReadFromFile.writeFile(outputFile, "Film title: " + ff.getTitle() + " (" +
                                ffYear + ")");
                        ReadFromFile.writeFile(outputFile, ff.getRunTime() + " min");
                        ReadFromFile.writeFile(outputFile, "Language: " + ff.getLanguage() + "\n");
                    }
                }
                if (!doesExist){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("FEATUREFILMS") &&
                    clArrayList.get(2).equals("AFTER")){
                String year = clArrayList.get(3);
                int intYear = Integer.parseInt(year);
                boolean doesThisExist = false;
                for (FeatureFilm ff : featureFilmObjects){
                    String ffYear = ff.getReleaseDate().substring(6);
                    int intFfYear = Integer.parseInt(ffYear);
                    if (intYear <= intFfYear){
                        doesThisExist = true;
                        ReadFromFile.writeFile(outputFile, "Film title: " + ff.getTitle() + " (" +
                                ffYear + ")");
                        ReadFromFile.writeFile(outputFile, ff.getRunTime() + " min");
                        ReadFromFile.writeFile(outputFile, "Language: " + ff.getLanguage() + "\n");
                    }
                }
                if (!doesThisExist){
                    ReadFromFile.writeFile(outputFile, "No result");
                }
            }
            if (clArrayList.get(0).equals("REMOVE") && clArrayList.get(1).equals("RATE")){
                String rateUserId = clArrayList.get(2);
                String rateFilmId = clArrayList.get(3);
                boolean isOK = false;
                for (User user : users){
                    if (user.getId().equals(rateUserId)){
                        if (user.userHashMap.containsKey(rateFilmId)){
                            isOK = true;
                            user.userHashMap.remove(rateFilmId);
                            ReadFromFile.writeFile(outputFile, "Your film rating was removed successfully");
                            for (FeatureFilm ff : featureFilmObjects){
                                if (ff.filmHashMap.containsKey(rateUserId) && ff.getId().equals(rateFilmId)){
                                    ff.filmHashMap.remove(rateUserId);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + ff.getTitle());
                                }
                            }
                            for (ShortFilm sf : shortFilmObjects){
                                if (sf.filmHashMap.containsKey(rateUserId) && sf.getId().equals(rateFilmId)){
                                    sf.filmHashMap.remove(rateUserId);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + sf.getTitle());
                                }
                            }
                            for (Documentary documentary : documentaryObjects){
                                if (documentary.filmHashMap.containsKey(rateUserId) && documentary.getId().equals(rateFilmId)){
                                    documentary.filmHashMap.remove(rateUserId);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + documentary.getTitle());
                                }
                            }
                            for (TVSeries tvs : tvSeriesObjects){
                                if (tvs.filmHashMap.containsKey(rateUserId) && tvs.getId().equals(rateFilmId)){
                                    tvs.filmHashMap.remove(rateUserId);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + tvs.getTitle());
                                }
                            }
                        }
                    }
                }
                if (!isOK){
                    ReadFromFile.writeFile(outputFile, "Command Failed");
                    ReadFromFile.writeFile(outputFile, "User ID: " + rateUserId);
                    ReadFromFile.writeFile(outputFile, "Film ID: " + rateFilmId);
                }
            }
            if (clArrayList.get(0).equals("EDIT") && clArrayList.get(1).equals("RATE")){
                String rateUserId = clArrayList.get(2);
                String rateFilmId = clArrayList.get(3);
                String newRating = clArrayList.get(4);
                boolean isOK = false;
                for (User user : users){
                    if (user.getId().equals(rateUserId)){
                        if (user.userHashMap.containsKey(rateFilmId)){
                            isOK = true;
                            user.userHashMap.replace(rateFilmId, newRating);
                            ReadFromFile.writeFile(outputFile, "New ratings done successfully");
                            for (FeatureFilm ff : featureFilmObjects){
                                if (ff.filmHashMap.containsKey(rateUserId) && ff.getId().equals(rateFilmId)){
                                    ff.filmHashMap.replace(rateUserId, newRating);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + ff.getTitle());
                                    ReadFromFile.writeFile(outputFile, "Your rating: " + newRating);
                                }
                            }
                            for (ShortFilm sf : shortFilmObjects){
                                if (sf.filmHashMap.containsKey(rateUserId) && sf.getId().equals(rateFilmId)){
                                    sf.filmHashMap.replace(rateUserId, newRating);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + sf.getTitle());
                                    ReadFromFile.writeFile(outputFile, "Your rating: " + newRating);
                                }
                            }
                            for (Documentary documentary : documentaryObjects){
                                if (documentary.filmHashMap.containsKey(rateUserId) && documentary.getId().equals(rateFilmId)){
                                    documentary.filmHashMap.replace(rateUserId, newRating);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + documentary.getTitle());
                                    ReadFromFile.writeFile(outputFile, "Your rating: " + newRating);
                                }
                            }
                            for (TVSeries tvs : tvSeriesObjects){
                                if (tvs.filmHashMap.containsKey(rateUserId) && tvs.getId().equals(rateFilmId)){
                                    tvs.filmHashMap.replace(rateUserId, newRating);
                                    ReadFromFile.writeFile(outputFile, "Film title: " + tvs.getTitle());
                                    ReadFromFile.writeFile(outputFile, "Your rating: " + newRating);
                                }
                            }
                        }
                    }
                }
                if (!isOK){
                    ReadFromFile.writeFile(outputFile, "Command Failed");
                    ReadFromFile.writeFile(outputFile, "User ID: " + rateUserId);
                    ReadFromFile.writeFile(outputFile, "Film ID: " + rateFilmId);
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("USER")){
                String rateUserId = clArrayList.get(2);
                boolean isThereUser = false;
                boolean doesRateExist = false;
                for (User user : users){
                    if (user.getId().equals(rateUserId)){
                        isThereUser = true;
                    }
                }
                if (!isThereUser){
                    ReadFromFile.writeFile(outputFile, "Command Failed");
                    ReadFromFile.writeFile(outputFile, "User ID: " + rateUserId);
                }
                if (isThereUser){
                    for (FeatureFilm ff : featureFilmObjects){
                        if (ff.filmHashMap.containsKey(rateUserId)){
                            doesRateExist = true;
                            ReadFromFile.writeFile(outputFile, ff.getTitle() + ": " +
                                    ff.filmHashMap.get(rateUserId));
                        }
                    }
                    for (ShortFilm sf : shortFilmObjects){
                        if (sf.filmHashMap.containsKey(rateUserId)){
                            doesRateExist = true;
                            ReadFromFile.writeFile(outputFile, sf.getTitle() + ": " +
                                    sf.filmHashMap.get(rateUserId));
                        }
                    }
                    for (Documentary documentary : documentaryObjects){
                        if (documentary.filmHashMap.containsKey(rateUserId)){
                            doesRateExist = true;
                            ReadFromFile.writeFile(outputFile, documentary.getTitle() + ": " +
                                    documentary.filmHashMap.get(rateUserId));
                        }
                    }
                    for (TVSeries tvs : tvSeriesObjects){
                        if (tvs.filmHashMap.containsKey(rateUserId)){
                            doesRateExist = true;
                            ReadFromFile.writeFile(outputFile, tvs.getTitle() + ": " +
                                    tvs.filmHashMap.get(rateUserId));
                        }
                    }
                }
                if (!doesRateExist){
                    ReadFromFile.writeFile(outputFile, "There is not any ratings so far");
                }
            }
            if (clArrayList.get(0).equals("VIEWFILM")){
                String filmIdToView = clArrayList.get(1);
                boolean voteExists = false;
                boolean filmExists = false;
                double total = 0;
                double average = 0;
                int counter = 0;
                for (String filmId : allFilmIds){
                    if (filmId.equals(filmIdToView)){
                        filmExists = true;
                    }
                }
                for (User user : users){
                    if (user.userHashMap.containsKey(filmIdToView)){
                        voteExists = true;
                        total = total + Double.parseDouble(user.userHashMap.get(filmIdToView));
                        counter ++;
                    }
                }
                if (voteExists){
                    average = total/counter;
                    String ratings = "Ratings: " + Double.toString(average).replace(".", ",") +
                            "/10 from " + Integer.toString(counter) + " user";
                    for (FeatureFilm ff : featureFilmObjects){
                        if (ff.getId().equals(filmIdToView)){
                            ReadFromFile.writeFile(outputFile, ff.getTitle() + " (" +
                                    ff.getReleaseDate().substring(6) + ")");
                            String writeline = ff.getGenre().toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile, writeline);
                            ArrayList<String> writerNames = new ArrayList<>();
                            for (String writerId : ff.getWriters()){
                                for (Writer writer: writers){
                                    if (writer.getId().equals(writerId)){
                                        writerNames.add(writer.getName() + " " + writer.getSurName());
                                    }
                                }
                            }
                            String forWriters = writerNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Writers: " + forWriters);
                            ArrayList<String> directorNames = new ArrayList<>();
                            for (String directorId : ff.getDirectors()){
                                for (Director director: directors){
                                    if (director.getId().equals(directorId)){
                                        directorNames.add(director.getName() + " " + director.getSurName());
                                    }
                                }
                            }
                            String forDirectors = directorNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Directors: " +  forDirectors);
                            ReadFromFile.writeFile(outputFile, ratings);
                        }
                    }
                    for (ShortFilm sf : shortFilmObjects){
                        if (sf.getId().equals(filmIdToView)){
                            ReadFromFile.writeFile(outputFile, sf.getTitle() + " (" +
                                    sf.getReleaseDate().substring(6) + ")");
                            String writeline = sf.getGenre().toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile, writeline);
                            ArrayList<String> writerNames = new ArrayList<>();
                            for (String writerId : sf.getWriters()){
                                for (Writer writer: writers){
                                    if (writer.getId().equals(writerId)){
                                        writerNames.add(writer.getName() + " " + writer.getSurName());
                                    }
                                }
                            }
                            String forWriters = writerNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Writers: " + forWriters);
                            ArrayList<String> directorNames = new ArrayList<>();
                            for (String directorId : sf.getDirectors()){
                                for (Director director: directors){
                                    if (director.getId().equals(directorId)){
                                        directorNames.add(director.getName() + " " + director.getSurName());
                                    }
                                }
                            }
                            String forDirectors = directorNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Directors: " +  forDirectors);
                            ReadFromFile.writeFile(outputFile, ratings);
                        }
                    }
                    for (Documentary doc : documentaryObjects){
                        if (doc.getId().equals(filmIdToView)){
                            ReadFromFile.writeFile(outputFile, doc.getTitle() + " (" +
                                    doc.getReleaseDate().substring(6) + ")");
                            ArrayList<String> directorNames = new ArrayList<>();
                            for (String directorId : doc.getDirectors()){
                                for (Director director: directors){
                                    if (director.getId().equals(directorId)){
                                        directorNames.add(director.getName() + " " + director.getSurName());
                                    }
                                }
                            }
                            String forDirectors = directorNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Directors: " +  forDirectors);
                            ReadFromFile.writeFile(outputFile, ratings);
                        }
                    }
                    for (TVSeries tvs : tvSeriesObjects){
                        if (tvs.getId().equals(filmIdToView)){
                            ReadFromFile.writeFile(outputFile, tvs.getTitle() + " (" +
                                    tvs.getStartDate().substring(6) + "-" + tvs.getEndDate().substring(6) +  ")");
                            ReadFromFile.writeFile(outputFile, tvs.getNumberOfSeasons() + " seasons, " +
                                    tvs.getNumberOfEpisodes() + " episodes");
                            String writeline = tvs.getGenre().toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile, writeline);
                            ArrayList<String> writerNames = new ArrayList<>();
                            for (String writerId : tvs.getWriters()){
                                for (Writer writer: writers){
                                    if (writer.getId().equals(writerId)){
                                        writerNames.add(writer.getName() + " " + writer.getSurName());
                                    }
                                }
                            }
                            String forWriters = writerNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Writers: " + forWriters);
                            ArrayList<String> directorNames = new ArrayList<>();
                            for (String directorId : tvs.getDirectors()){
                                for (Director director: directors){
                                    if (director.getId().equals(directorId)){
                                        directorNames.add(director.getName() + " " + director.getSurName());
                                    }
                                }
                            }
                            String forDirectors = directorNames.toString().replace("[", "").replace("]", "");
                            ReadFromFile.writeFile(outputFile,"Directors: " +  forDirectors);
                            ReadFromFile.writeFile(outputFile, ratings);
                        }
                    }
                }
                if (filmExists){
                    if (!voteExists){
                        ReadFromFile.writeFile(outputFile, "Awaiting for votes");
                    }
                }
                if (!filmExists){
                    ReadFromFile.writeFile(outputFile, "Command Failed");
                    ReadFromFile.writeFile(outputFile, "Film ID: " + filmIdToView);
                }
            }
            if (clArrayList.get(0).equals("LIST") && clArrayList.get(1).equals("FILMS") &&
                    clArrayList.get(2).equals("BY") && clArrayList.get(3).equals("RATE")){
                    ReadFromFile.writeFile(outputFile, "FeatureFilm:");
                    for (FeatureFilm ff : featureFilmObjects){
                        ReadFromFile.writeFile(outputFile, ff.getTitle() + " (" +
                                ff.getReleaseDate().substring(6) + ") Ratings:");
                    }
                    if (featureFilmObjects.isEmpty()){
                        ReadFromFile.writeFile(outputFile, "No result");
                    }
                    ReadFromFile.writeFile(outputFile, "");
                    ReadFromFile.writeFile(outputFile, "ShortFilm:");
                    for (ShortFilm sf : shortFilmObjects){
                        ReadFromFile.writeFile(outputFile, sf.getTitle() + " (" +
                                sf.getReleaseDate().substring(6) + ") Ratings:");
                    }
                    if (shortFilmObjects.isEmpty()){
                        ReadFromFile.writeFile(outputFile, "No result");
                    }
                    ReadFromFile.writeFile(outputFile, "");
                    ReadFromFile.writeFile(outputFile, "Documentary:");
                    for (Documentary doc : documentaryObjects){
                        ReadFromFile.writeFile(outputFile, doc.getTitle() + " (" +
                                doc.getReleaseDate().substring(6) + ") Ratings:");
                    }
                    if (documentaryObjects.isEmpty()){
                        ReadFromFile.writeFile(outputFile, "No result");
                    }
                    ReadFromFile.writeFile(outputFile, "");
                    ReadFromFile.writeFile(outputFile, "TVSeries:");
                    for (TVSeries tvs : tvSeriesObjects){
                        ReadFromFile.writeFile(outputFile, tvs.getTitle() + " (" +
                                tvs.getStartDate().substring(6) + "-" +tvs.getEndDate().substring(6) + ") Ratings:");
                    }
            }

            // End of the current command
            ReadFromFile.writeFile(outputFile, "\n" +
                    "-----------------------------------------------------------------------------------------------------");
        }
    }
}

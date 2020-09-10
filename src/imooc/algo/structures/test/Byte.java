package imooc.algo.structures.test;

import java.util.Vector;

public class Byte {
    public static void main(String[] args) {
        Byte bt = new Byte(new String[]{"sports", "outdoor sports", "music", "pet"});
        bt.show("sports");
    }

    public void show(String q){
        for (String s : findTags(q)
        ) {
            System.out.println(s);
        }
    }

    private String[] predefinedTags;

    public Byte(String[] predefinedTags) {
        this.predefinedTags = predefinedTags;
    }

    public String[] findTags(String query) {
        Vector<String> resTags = new Vector<>();

        for(int i = 0; i < predefinedTags.length; i++) {

            if(query.equals(predefinedTags[i])){
                resTags.add(predefinedTags[i]);
            } else {
                String[] words= predefinedTags[i].split(" ");
                String[] querywords = query.split(" ");

                for(int j = 0; j < words.length; j++) {
                    for (int k = 0; k < querywords.length; k++) {
                        if(words[j].equals(querywords[k])) {
                            resTags.add(predefinedTags[i]);
                            continue;

                        }
                    }
                }
            }

        }

        String[] resArr = new String[resTags.size()];

        for(int i = 0; i < resTags.size(); i++) {
            resArr[i] = resTags.get(i);
        }

        return resArr;
    }
}

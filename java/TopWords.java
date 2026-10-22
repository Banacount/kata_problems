/*
 *
 * ProblemId: 51e056fe544cf36c410000fb
 * Status: solved (assisted :3)
 * 
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopWords {
    public static List<String> top3(String s) {
        System.out.println(s);
        List<String> result = new ArrayList<>();
        List<String> words = new ArrayList<>();
        List<String> sentence = new ArrayList<>();
        HashMap <String, Integer> counts = new HashMap<>();
        
        String buf = "";
        for (int w = 0; w < s.length(); w++) {
            char let = Character.toLowerCase(s.charAt(w));
            Boolean isLetterOrApostrophe = (let >= 'a' && let <= 'z') || let == 39;
            Boolean endHasBuff = (buf.length() > 0 && w + 1 == s.length());

            if (isLetterOrApostrophe) {
                buf += let;
            }

            if (!isLetterOrApostrophe || endHasBuff) {
                if (buf.length() > 0) {
                    if (!buf.trim().equals("") && buf.matches(".*[a-z].*")) {
                        Boolean isAlready = false;
                        for (String str : words) {
                            if (str.equals(buf)) {
                                isAlready = true;
                                break;
                            }
                        }
                        if (!isAlready) words.add(buf);
                        sentence.add(buf);
                    }
                    buf = "";
                }
            }
        }

        // Handle last buffer
        if (buf.trim().length() > 0) {
            Boolean isAlready = false;
            for (String str : words) {
                if (str.equals(buf)) {
                    isAlready = true;
                    break;
                }
            }

            if (!isAlready) words.add(buf);
            sentence.add(buf);
        }

        // Count the shits
        for (String str : words) {
            for (String w : sentence) {
                if (str.equals(w)) counts.merge(str, 1, Integer::sum);
            }
        }
        //System.out.println(counts);

        for (int i = 0; i < words.size(); i++) {
            if (i >= 3) break;
            String biggest = words.get(0);
            
            for (String str : words) {
                int old = counts.get(biggest);
                int cur = counts.get(str);

                if (cur > old) biggest = str;
            }

            Boolean isAlready = false;
            for (String str : result) {
                if (str.equals(biggest)) {
                    isAlready = true;
                    break;
                }
            }

            if (isAlready) continue;
            result.add(biggest);
            counts.put(biggest, 0);
        }

        return result;
    }

    public static void main (String[] args) {
        /*
        List<String> arrString = top3(
        """
        In a village of La Mancha, the name of which I have no desire to call to
        mind, there lived not long since one of those gentlemen that keep a lance
        in the lance-rack, an old buckler, a lean hack, and a greyhound for
        coursing. An olla of rather more beef than mutton, a salad on most
        nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
        on Sundays, made away with three-quarters of his income.
        """);

        List<String> test2 = top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");
        */
        List<String> test3 = top3(":h'g,H'G h'g: VDbFRPUhF eGOy  H'G-/VdbFRpuhF/h'G/Egoy EgOy  'uzjotO'p,VdBfrPuhF/ 'UZJoto'P 'uzJOtO'p  h'g, vDBfrpUHF/vdbFRPUhf;H'g VDbfRPUHF-:'uZJotO'p  'UZjotO'p  'UzjOtO'p H'G,'UZjoTo'P,VdbfrpUHf. H'g vDbFrpUHF  'uZJotO'P:vDbFRpUhF_;egoY vdBFRPuhf  eGOy :h'g/'UzJOtO'p _H'G/VdbFrPUHF/_VDbfrPuHf_ VDbfrpuhf  VdBfrPUhf,eGOy -eGOy? hyek';EGoY H'g ,EGOy 'UZJotO'p h'g- 'UzjOTo'P hYeK' -h'G -vDbFrpuhf: H'G 'UzJoTo'p !'UZJOtO'p h'g _hYeK' vdBFrpUhF:EgOy egOy ,h'G:'uzjOtO'p  egoy! H'G.-vdbfRPuHf:H'G -'UzJOTO'P 'UZJOto'P  'UZJOTO'P  vdbFrPuHf::vDbfrPuhF ");

        System.out.println("\n" + test3);
    }
}

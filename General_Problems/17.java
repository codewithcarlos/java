
import java.util.*;

class Solution {
  static class Visit {
    String userName;
    int timestamp;
    String website;

    Visit(String u, int t, String w) {
      userName = u;
      timestamp = t;
      website = w;
    }
  }

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    List<Visit> visitList = new ArrayList<>();
    for (int i = 0; i < username.length; i++) {
      visitList.add(new Visit(username[i], timestamp[i], website[i]));
    }

    Collections.sort(visitList, (a, b) -> a.timestamp - b.timestamp);

    // Collect list of websites for each user
    Map<String, List<String>> userWebSitesMap = new HashMap<>();
    for (Visit v : visitList) {
      userWebSitesMap.putIfAbsent(v.userName, new ArrayList<>());
      userWebSitesMap.get(v.userName).add(v.website);
    }

    Map<List<String>, Integer> seqUserFreMap = new HashMap<>();
    // Now get all the values of all the users
    for (List<String> websitesList : userWebSitesMap.values()) {
      if (websitesList.size() < 3)
        continue;
      Set<List<String>> sequencesSet = generate3Seq(websitesList);
      for (List<String> seq : sequencesSet) {
        seqUserFreMap.put(seq, seqUserFreMap.getOrDefault(seq, 0) + 1);
      }
    }

    List<String> res = new ArrayList<>();
    int MAX = 0;
    for (Map.Entry<List<String>, Integer> entry : seqUserFreMap.entrySet()) {
      if (entry.getValue() > MAX) {
        MAX = entry.getValue();
        res = entry.getKey();
      } else if (entry.getValue() == MAX) {
        if (entry.getKey().toString().compareTo(res.toString()) < 0) {
          res = entry.getKey();
        }
      }
    }
    return res;
  }

  // It will not return duplicate seq for each user that why we are using Set
  private Set<List<String>> generate3Seq(List<String> websitesList) {
    Set<List<String>> setOfListSeq = new HashSet<>();
    for (int i = 0; i < websitesList.size(); i++) {
      for (int j = i + 1; j < websitesList.size(); j++) {
        for (int k = j + 1; k < websitesList.size(); k++) {
          List<String> list = new ArrayList<>();
          list.add(websitesList.get(i));
          list.add(websitesList.get(j));
          list.add(websitesList.get(k));
          setOfListSeq.add(list);
        }
      }
    }
    return setOfListSeq;
  }
}
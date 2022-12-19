package lesson8filter.svc;

import java.util.List;

public interface CalcHistory {

  void store(String userId, int x, int y, int z) throws Exception;
  List<String> getAll(String userId) throws Exception;

}

package lesson6;

import java.util.List;

public interface CalcHistory {

  void store(int x, int y, int z) throws Exception;
  List<String> getAll() throws Exception;

}

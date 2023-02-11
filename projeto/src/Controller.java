public interface Controller {

    boolean create(Object usuario);

    boolean delete(int index);

    boolean update(int index, Object usuario);

    void read();
}

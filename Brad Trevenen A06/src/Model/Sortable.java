
package Model;

public interface Sortable {
    public void sort(int sortType, int sortField);
    public int getSortType();
    public void setSortType(int sortType);
    public int getSortField();
    public void setSortField(int sortField);
}

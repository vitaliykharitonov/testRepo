package HomeWorkLesson7;

public class Pagination {
        private int limit;
        private int offset;
        private int total;

        public Pagination(int limit, int offset, int total) {
            this.limit = limit;
            this.offset = offset;
            this.total = total;
        }

    @Override
    public String toString() {
        return "  \"pagination\": {" + "\n" +
                "    \"limit\": \"" + limit + "\",\n" +
                "    \"offset\": \"" + offset + "\",\n" +
                "    \"total\": \"" + total + "\"\n" +
                "  }";
    }
}

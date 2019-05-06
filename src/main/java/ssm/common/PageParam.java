package ssm.common;



public class PageParam {

    private final int DEFAULT_PAGE_NUM = 0;
    private final int DEFAULT_PAGE_SIZE = 20;

    private Object pageNum;
    private Object pageSize;


    public PageParam(Object pageNum, Object pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        check();
    }

    public PageParam(Object pageNum) {
        this.pageNum = pageNum;
        this.pageSize = DEFAULT_PAGE_SIZE;
        check();
    }


    public int getPageNum() {
        return (Integer) pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return (Integer) pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    private void check(){

        int num = DEFAULT_PAGE_NUM, size;


        if (pageNum == null){
          pageNum = DEFAULT_PAGE_NUM;
        } else if (pageNum instanceof Integer){
            num = (Integer) pageNum;
        } else if (pageNum instanceof Long){
            num =  ((Long) pageNum).intValue();
        } else if (pageNum instanceof String){
            try {
                num = Integer.parseInt((String) pageNum);
            }catch (NumberFormatException e){
                num = DEFAULT_PAGE_NUM;
            }
        }else {
            num = DEFAULT_PAGE_NUM;
        }

        if (num < 0){
            num = DEFAULT_PAGE_NUM;
        }

        this.pageNum = num;

        if (pageSize == null){
            size = DEFAULT_PAGE_SIZE;
        } else if (pageSize instanceof Integer){
            size = (Integer) pageSize;
        } else if (pageSize instanceof Long){
            size = ((Long) pageSize).intValue();
        }else if (pageSize instanceof String){
            try {
                size = Integer.parseInt((String)pageSize);
            }catch (NumberFormatException e){
                size = DEFAULT_PAGE_SIZE;
            }
        }else {
            size = DEFAULT_PAGE_SIZE;
        }

        if (size < 0){
            this.pageSize = DEFAULT_PAGE_SIZE;
        }

        this.pageSize = size;
    }


}

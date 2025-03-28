public class pieces
{
    private int xCor;
    private int yCor;
    private boolean king;
    private String player;

    public pieces()
    {
        xCor = 0;
        yCor = 0;
        king = false;
        player = " ";
    }

    public pieces( int x, int y, boolean b, String p)
    {
        xCor = x;
        yCor = y;
        king = b;
        player = p;
    }

    public int getX()
    {
        return xCor;
    }

    public int getY()
    {
        return yCor;
    }

    public boolean kingStatus()
    {
        return king;
    }

    public String getPlayer()
    {
        return player;
    }

    public void setX(int x)
    {
        xCor = x;
    }

    public void setY(int y)
    {
        yCor = y;
    }

    public void makeKing(boolean k)
    {
        king = k;
    }
    public void setPlayer(String name)
    {
        player = name;
    }
}

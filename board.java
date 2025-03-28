import java.util.*;
public class board
{
    public static void main(String[] args)
    {
        player playerR = new player();
        player playerB = new player();
        System.out.println("Welcome to Checkers!");

        pieces [][] board = setupBoard();

        System.out.println(printboard(board));


        while (playerR.getScore() != 12 || playerB.getScore() != 12)
        {
            //player 1
            System.out.println("Player 1's turn! ");
            int originalX = getpos("X coordinate of piece you want to move: ");
            int originalY = getpos("Y coordinate of piece you want to move: ");
            int newX = getpos("X coordinate of place you want the piece to move to: ");
            int newY = getpos("Y coordinate of place you want the piece to move to: ");
            boolean again = checkposR(originalX,originalY,newX,newY,board, playerR);

            while (again)
            {
                originalX = getpos("X coordinate of piece you want to move: ");
                originalY = getpos("Y coordinate of piece you want to move: ");
                newX = getpos("X coordinate of place you want the piece to move to: ");
                newY = getpos("Y coordinate of place you want the piece to move to: ");
                again = checkposR(originalX,originalY,newX,newY,board, playerR);
            }

            //player 2
            System.out.println("Player 2's turn! ");
            originalX = getpos("X coordinate of piece you want to move: ");
            originalY = getpos("Y coordinate of piece you want to move: ");
            newX = getpos("X coordinate of place you want the piece to move to: ");
            newY = getpos("Y coordinate of place you want the piece to move to: ");
            again = checkposB(originalX,originalY,newX,newY,board, playerB);

            while (again)
            {
                originalX = getpos("X coordinate of piece you want to move: ");
                originalY = getpos("Y coordinate of piece you want to move: ");
                newX = getpos("X coordinate of place you want the piece to move to: ");
                newY = getpos("Y coordinate of place you want the piece to move to: ");
                again = checkposB(originalX,originalY,newX,newY,board, playerB);
            }
        }

    }

    public static pieces[][] setupBoard()
    {
        pieces board [] [] = new pieces[8][8];
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                pieces piece = new pieces(j, i, false, " ");
                board[piece.getY()][piece.getX()] = piece;
            }
        }


        for (int i = 0; i < 3; i++)
        {
            if (i%2 == 0)
            {
                for (int j = 1; j < 8; j += 2)
                {
                    board[i][j].setPlayer("R");
                }
            }
            else
            {
                for (int j = 0; j < 8; j += 2)
                {
                    board[i][j].setPlayer("R");
                }
            }
        }

        for (int i = 7; i > 4; i--)
        {
            if (i%2 == 0)
            {
                for (int j = 1; j < 8; j += 2)
                {
                    board[i][j].setPlayer("B");
                }
            }
            else
            {
                for (int j = 0; j < 8; j += 2)
                {
                    board[i][j].setPlayer("B");
                }
            }
        }
        return board;
    }

    public static String printboard (pieces [] [] board)
    {
        String xCord = "     1     2     3     4     5     6     7     8\n";
        String top = "   _____ _____ _____ _____ _____ _____ _____ _____\n";
        String row1 = "1 |  " + board[0][0].getPlayer() + "  |  " + board[0][1].getPlayer() + "  |  " + board[0][2].getPlayer() + "  |  " + board[0][3].getPlayer() + "  |  " + board[0][4].getPlayer() + "  |  " + board[0][5].getPlayer() + "  |  " + board[0][6].getPlayer() + "  |  " + board[0][7].getPlayer() + "  |\n";
        String bottom = ("  |_____|_____|_____|_____|_____|_____|_____|_____|\n");
        String row2 = "2 |  " + board[1][0].getPlayer() + "  |  " + board[1][1].getPlayer() + "  |  " + board[1][2].getPlayer() + "  |  " + board[1][3].getPlayer() + "  |  " + board[1][4].getPlayer() + "  |  " + board[1][5].getPlayer() + "  |  " + board[1][6].getPlayer() + "  |  " + board[1][7].getPlayer() + "  |\n";
        String row3 = "3 |  " + board[2][0].getPlayer() + "  |  " + board[2][1].getPlayer() + "  |  " + board[2][2].getPlayer() + "  |  " + board[2][3].getPlayer() + "  |  " + board[2][4].getPlayer() + "  |  " + board[2][5].getPlayer() + "  |  " + board[2][6].getPlayer() + "  |  " + board[2][7].getPlayer() + "  |\n";
        String row4 = "4 |  " + board[3][0].getPlayer() + "  |  " + board[3][1].getPlayer() + "  |  " + board[3][2].getPlayer() + "  |  " + board[3][3].getPlayer() + "  |  " + board[3][4].getPlayer() + "  |  " + board[3][5].getPlayer() + "  |  " + board[3][6].getPlayer() + "  |  " + board[3][7].getPlayer() + "  |\n";
        String row5 = "5 |  " + board[4][0].getPlayer() + "  |  " + board[4][1].getPlayer() + "  |  " + board[4][2].getPlayer() + "  |  " + board[4][3].getPlayer() + "  |  " + board[4][4].getPlayer() + "  |  " + board[4][5].getPlayer() + "  |  " + board[4][6].getPlayer() + "  |  " + board[4][7].getPlayer() + "  |\n";
        String row6 = "6 |  " + board[5][0].getPlayer() + "  |  " + board[5][1].getPlayer() + "  |  " + board[5][2].getPlayer() + "  |  " + board[5][3].getPlayer() + "  |  " + board[5][4].getPlayer() + "  |  " + board[5][5].getPlayer() + "  |  " + board[5][6].getPlayer() + "  |  " + board[5][7].getPlayer() + "  |\n";
        String row7 = "7 |  " + board[6][0].getPlayer() + "  |  " + board[6][1].getPlayer() + "  |  " + board[6][2].getPlayer() + "  |  " + board[6][3].getPlayer() + "  |  " + board[6][4].getPlayer() + "  |  " + board[6][5].getPlayer() + "  |  " + board[6][6].getPlayer() + "  |  " + board[6][7].getPlayer() + "  |\n";
        String row8 = "8 |  " + board[7][0].getPlayer() + "  |  " + board[7][1].getPlayer() + "  |  " + board[7][2].getPlayer() + "  |  " + board[7][3].getPlayer() + "  |  " + board[7][4].getPlayer() + "  |  " + board[7][5].getPlayer() + "  |  " + board[7][6].getPlayer() + "  |  " + board[7][7].getPlayer() + "  |\n";
        return xCord + top + row1 + bottom + row2 + bottom + row3 + bottom + row4 + bottom + row5 + bottom + row6 + bottom + row7 + bottom + row8 + bottom;
    }

    public static int getpos (String a)
    {
        System.out.println(a);
        Scanner input = new Scanner(System.in);
        int pos = input.nextInt() - 1;
        input.nextLine();
        while (pos > 7 || pos < 0)
        {
            System.out.println("Out of bound. Try again.");
            System.out.println(a);
            pos = input.nextInt() - 1;
            input.nextLine();
        }
        return pos;
    }

    public static void newpos (int orgX, int orgY, int newX, int newY, pieces [] [] board, String e)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == orgY && j == orgX)
                {
                    board[i][j].setPlayer(" ");
                }
                if (i == newY && j == newX)
                {
                    board[i][j].setPlayer(e);
                }
            }
        }
    }

    public static void checkK (int orgX, int orgY, int newX, int newY, pieces [][] board)
    {
        if (board[orgY][orgX].getPlayer().equals("R"))
        {
            for (int i = 0; i < 8; i++)
            {
                if (newY == 7 && newX == i)
                {
                    board[orgY][orgX].makeKing(true);
                }
            }
        }
        if (board[orgY][orgX].getPlayer().equals("B"))
        {
            for (int i = 0; i < 8; i++)
            {
                if (newY == 0 && newX == i)
                {
                    board[orgY][orgX].makeKing(true);
                }
            }
        }
    }

    public static void moveK (int orgX, int orgY, int newX, int newY, pieces [][] board, String e)
    {
        board[orgY][orgX].makeKing(false);
        board[newY][newX].makeKing(true);
        newpos(orgX, orgY, newX, newY, board, e);
    }
    public static void multiR (int orgX, int orgY, pieces [][] board, player a)
    {
        int counter = 0;
        //at the end of the board and for the king only
        if (orgY > 5)
        {
            //at the left edge of the board
            if (orgX < 2)
            {
                if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
            //at the right edge of the board
            else if (orgX > 5)
            {
                if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX-1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
            //else if at the middle of the end of the board
            else
            {
                if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX-1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
                if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
        }
        // at the top of the board - for any pieces to move
        else if (orgY < 2)
        {
            //if at the left edge of the board, can only move diagonally right
            if (orgX < 2)
            {
                if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
            //at the right edge, can only move diagonally left
            else if (orgX > 5)
            {
                if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
            //middle of the board, can move diagonally down right or left
            else
            {
                if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
                if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
        }
        //left side but in the middle, can only move diagonally right up or right down
        else if (orgX < 2)
        {
            if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
        }
        //right side but in the middle, can only move diagonally left up or left down
        else if (orgX > 5)
        {
            if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX-1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
        }
        else
        {
            if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX-1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
            if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
            {
                counter++;
            }
        }
        if (counter == 0)
        {
            System.out.println("");
        }
        else
        {
            if (counter > 1)
            {
                System.out.println("You can jump more than one of your opponent's piece. Which way would you like to go?");
                int newX = getpos("X coordinate of place you want the piece to move to: ");
                int newY = getpos("Y coordinate of place you want the piece to move to: ");
                checkposR(orgX, orgY, newX, newY, board, a);
                multiR(newX,newY,board,a);
            }
            else
            {
                if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX-1].getPlayer().equals("ℬ")))
                {
                    checkposR(orgX,orgY,orgX-2,orgY-2,board, a);
                    multiR(orgX-2,orgY-2, board, a);
                }
                else if (board[orgY][orgX].kingStatus() && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
                {
                    checkposR(orgX,orgY,orgX+2,orgY-2,board, a);
                    multiR(orgX+2,orgY-2, board, a);
                }
                else if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
                {
                    checkposR(orgX,orgY,orgX+2,orgY+2,board, a);
                    multiR(orgX+2,orgY+2, board, a);
                }
                else if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
                {
                    checkposR(orgX,orgY,orgX-2,orgY+2,board, a);
                    multiR(orgX-2,orgY+2, board, a);
                }
            }
        }
    }

    public static boolean checkposR (int orgX, int orgY, int newX, int newY, pieces [][] board, player a)
    {
        boolean errorR = true;
        checkK(orgX,orgY,newX,newY,board);
        // if R is king - can move back
        if (board[orgY][orgX].kingStatus() && board[newY][newX].getPlayer().equals(" ") && (newX == orgX-2 && newY == orgY-2 && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX-1].getPlayer().equals("ℬ"))) || (newX == orgX+2 && newY == orgY-2 && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ"))))
        {
            errorR = false;
            moveK(orgX, orgY, newX, newY, board, "ℛ");
            if (newX == orgX-2 && newY == orgY-2 && (board[orgY-1][orgX-1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
            {
                board[orgY - 1][orgX - 1].setPlayer(" ");
            }
            else if (newX == orgX+2 && newY == orgY-2 && (board[orgY-1][orgX+1].getPlayer().equals("B") || board[orgY-1][orgX+1].getPlayer().equals("ℬ")))
            {
                board[orgY - 1][orgX + 1].setPlayer(" ");
            }
            System.out.println(printboard(board));
            a.setScore(a.getScore()+1);
            multiR(newX,newY,board, a);
        }
        // as long as piece is move 2 step diagonal to other side - does not have to be king
        if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[newY][newX].getPlayer().equals(" ") && (newX == orgX+2 && newY == orgY+2 && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ"))) || (newX == orgX-2 && newY == orgY+2 && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ"))))
        {
            errorR = false;
            if (board[orgY][orgX].kingStatus())
            {
                moveK(orgX, orgY, newX, newY, board, "ℛ");
            }
            else
            {
                newpos(orgX, orgY, newX, newY, board, "R");
            }
            if (newX == orgX+2 && newY == orgY+2 && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
            {
                board[orgY + 1][orgX + 1].setPlayer(" ");
            }
            else if (newX == orgX-2 && newY == orgY+2 && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
            {
                board[orgY + 1][orgX - 1].setPlayer(" ");
            }
            System.out.println(printboard(board));
            a.setScore(a.getScore()+1);
            multiR(newX,newY,board, a);
        }
        // if piece did not jump anyone and is moving one step diagonally down
        if (errorR && (board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && ((newX == orgX+1 && newY == orgY+1) || (newX == orgX-1 && newY == orgY+1)) && board[newY][newX].getPlayer().equals(" "))
        {
            if (!board[orgY][orgX].kingStatus())
            {
                newpos(orgX, orgY, newX, newY, board, "R");
            }
            else
            {
                moveK(orgX, orgY, newX, newY, board, "ℛ");
            }
            System.out.println(printboard(board));
            return false;
        }
        else
        {
            // if king and can move back, don't throw illegal move
            if (board[orgY][orgX].kingStatus() && ((newX == orgX-1 && newY == orgY-1) || (newX == orgX+1 && newY == orgY-1)))
            {
                moveK(orgX, orgY, newX, newY, board, "ℛ");
                System.out.println(printboard(board));
                return false;
            }
            else if (!errorR)
            {
                return false;
            }
            else
            {
                System.out.println("Illegal move. Try again. ");
                return true;
            }
        }
    }
    public static void multiB(int orgX, int orgY, pieces [][] board, player b)
    {
        int counter = 0;
        if (orgY < 2)
        {
            if (orgX < 2)
            {
                if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("R") || board[orgY+1][orgX+1].getPlayer().equals("ℛ")))
                {
                    counter++;
                }
            }
            else if (orgX > 5)
            {
                if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("R") || board[orgY+1][orgX-1].getPlayer().equals("ℛ")))
                {
                    counter++;
                }
            }
            else
            {
                if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("B") || board[orgY+1][orgX-1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
                if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("B") || board[orgY+1][orgX+1].getPlayer().equals("ℬ")))
                {
                    counter++;
                }
            }
        }
        else if (orgY > 5)
        {
            if (orgX < 2)
            {
                if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ")))
                {
                    counter++;
                }
            }
            else if (orgX > 5)
            {
                if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("R") || board[orgY-1][orgX-1].getPlayer().equals("ℛ")))
                {
                    counter++;
                }
            }
            else
            {
                if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ")))
                {
                    counter++;
                }
                if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("R") || board[orgY-1][orgX-1].getPlayer().equals("ℛ")))
                {
                    counter++;
                }
            }
        }
        else if (orgX < 2)
        {
            if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("R") || board[orgY+1][orgX+1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
        }
        else if (orgX > 5)
        {
            if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("R") || board[orgY+1][orgX-1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("R") || board[orgY-1][orgX-1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
        }
        else
        {
            if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("R") || board[orgY+1][orgX-1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
            if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("R") || board[orgY+1][orgX+1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
            if ((board[orgY][orgX].getPlayer().equals("R") || board[orgY][orgX].getPlayer().equals("ℛ")) && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("R") || board[orgY-1][orgX-1].getPlayer().equals("ℛ")))
            {
                counter++;
            }
        }
        if (counter == 0)
        {
            System.out.println("");
        }
        else
        {
            if (counter > 1)
            {
                System.out.println("You can jump more than one of your opponent's piece. Which way would you like to go?");
                int newX = getpos("X coordinate of place you want the piece to move to: ");
                int newY = getpos("Y coordinate of place you want the piece to move to: ");
                checkposB(orgX, orgY, newX, newY, board, b);
                multiB(newX,newY,board, b);
            }
            else
            {
                if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX-2].getPlayer().equals(" ") && (board[orgY+1][orgX-1].getPlayer().equals("R") || board[orgY+1][orgX-1].getPlayer().equals("ℛ")))
                {
                    checkposR(orgX,orgY,orgX-2,orgY+2,board, b);
                    multiR(orgX-2,orgY+2, board, b);
                }
                else if (board[orgY][orgX].kingStatus() && board[orgY+2][orgX+2].getPlayer().equals(" ") && (board[orgY+1][orgX+1].getPlayer().equals("R") || board[orgY+1][orgX+1].getPlayer().equals("ℛ")))
                {
                    checkposR(orgX,orgY,orgX+2,orgY+2,board, b);
                    multiR(orgX+2,orgY+2, board, b);
                }
                else if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX+2].getPlayer().equals(" ") && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ")))
                {
                    checkposR(orgX,orgY,orgX+2,orgY-2,board, b);
                    multiR(orgX+2,orgY-2, board, b);
                }
                else if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[orgY-2][orgX-2].getPlayer().equals(" ") && (board[orgY-1][orgX-1].getPlayer().equals("R") || board[orgY-1][orgX-1].getPlayer().equals("ℛ")))
                {
                    checkposR(orgX,orgY,orgX-2,orgY-2,board, b);
                    multiR(orgX-2,orgY-2, board, b);
                }
            }
        }
    }

    public static boolean checkposB (int orgX, int orgY, int newX, int newY, pieces [][] board, player b)
    {
        boolean errorB = true;
        checkK(orgX,orgY, newX,newY,board);
        if (board[orgY][orgX].getPlayer().equals("ℬ") && board[orgY][orgX].kingStatus() && board[newY][newX].getPlayer().equals(" ") && (newX == orgX+2 && newY == orgY+2 && (board[orgY+1][orgX+1].getPlayer().equals("R") || board[orgY+1][orgX+1].getPlayer().equals("ℛ"))) || (newX == orgX-2 && newY == orgY+2 && (board[orgY+1][orgX-1].getPlayer().equals("R") || board[orgY+1][orgX-1].getPlayer().equals("ℛ"))))
        {
            errorB = false;
            moveK(orgX, orgY, newX, newY, board, "ℬ");
            if (newX == orgX+2 && newY == orgY+2 && (board[orgY+1][orgX+1].getPlayer().equals("R") || board[orgY+1][orgX+1].getPlayer().equals("ℛ")))
            {
                board[orgY + 1][orgX + 1].setPlayer(" ");
            }
            else if (newX == orgX-2 && newY == orgY+2 && (board[orgY+1][orgX-1].getPlayer().equals("R") || board[orgY+1][orgX-1].getPlayer().equals("ℛ")))
            {
                board[orgY + 1][orgX - 1].setPlayer(" ");
            }
            System.out.println(printboard(board));
            b.setScore(b.getScore()+1);
            multiB(newX, newY, board, b);
        }
        if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && board[newY][newX].getPlayer().equals(" ") && (newX == orgX-2 && newY == orgY-2 && (board[orgY-1][orgX-1].getPlayer().equals("ℛ") || board[orgY-1][orgX-1].getPlayer().equals("R"))) || (newX == orgX+2 && newY == orgY-2 && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ"))))
        {
            errorB = false;
            if (board[orgY][orgX].kingStatus())
            {
                moveK(orgX, orgY, newX, newY, board, "ℬ");
            }
            else
            {
                newpos(orgX, orgY, newX, newY, board, "B");
            }
            if (newX == orgX-2 && newY == orgY-2 && (board[orgY-1][orgX-1].getPlayer().equals("R") || board[orgY-1][orgX-1].getPlayer().equals("ℛ")))
            {
                board[orgY - 1][orgX - 1].setPlayer(" ");
            }
            else if (newX == orgX+2 && newY == orgY-2 && (board[orgY-1][orgX+1].getPlayer().equals("R") || board[orgY-1][orgX+1].getPlayer().equals("ℛ")))
            {
                board[orgY - 1][orgX + 1].setPlayer(" ");
            }
            System.out.println(printboard(board));
            b.setScore(b.getScore()+1);
            multiB(newX, newY, board, b);
        }
        if ((board[orgY][orgX].getPlayer().equals("B") || board[orgY][orgX].getPlayer().equals("ℬ")) && ((newX == orgX-1 && newY == orgY-1) || (newX == orgX+1 && newY == orgY-1)) && board[newY][newX].getPlayer().equals(" "))
        {
            if (!board[orgY][orgX].kingStatus())
            {
                newpos(orgX, orgY, newX, newY, board, "B");
            }
            else
            {
                moveK(orgX, orgY, newX, newY, board, "ℬ");
            }
            System.out.println(printboard(board));
            return false;
        }
        else
        {
            if (board[orgY][orgX].kingStatus() && ((newX == orgX+1 && newY == orgY+1) || (newX == orgX-1 && newY == orgY+1)))
            {
                {
                    moveK(orgX, orgY, newX, newY, board, "ℬ");
                    System.out.println(printboard(board));
                    return false;
                }
            }
            else if (!errorB)
            {
                return false;
            }
            else
            {
                System.out.println("Illegal move. Try again. ");
                return true;
            }
        }
    }
}

package com.example.xogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPostions = {0, 0, 0, 0, 0, 0, 0, 0, 0};// making each cube's value=0;
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{2,4,6});
        combinationList.add(new int[]{0,4,8});

        String getPlayerOneName=getIntent().getStringExtra("PlayerOne");
        String getPlayerTwoName=getIntent().getStringExtra("PlayerTwo");

        {
            binding.image1.setOnClickListner(new View.OnClickListener());{
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(0)){
                    performAction((ImageView) view,0);
                }
            }
        });



            binding.image2.setOnClickListner(new View.OnClickListener());{
            @Override


            public void OnClick (View view){
                if (isBoxSelectable(1)){
                    performAction((ImageView) view,1);
                }
            }
        });

            binding.image3.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(2)){
                    performAction((ImageView) view,2);
                }
            }
        });

            binding.image4.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(3)){
                    performAction((ImageView) view,3);
                }
            }
        });

            binding.image5.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(4)){
                    performAction((ImageView) view,4);
                }
            }
        });
            binding.image6.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(5)){
                    performAction((ImageView) view,5);
                }
            }
        });
            binding.image7.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(6)){
                    performAction((ImageView) view,6);
                }
            }
        });

            binding.image8.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(7)){
                    performAction((ImageView) view,7);
                }
            }
        });


            binding.image9.setOnClickListner(new View.OnClickListener()){
            @Override
            public  void OnClick (View view){
                if (isBoxSelectable(8)){
                    performAction((ImageView) view,8);
                }
            }
        });

        }

    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPostions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.delete);
            if (checkResults()){
                ResultDialog resultDialog =new ResultDialog()(MainActivity.this,binding.playerOneName.getText().toString()
                +"Is the Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if (totalSelectedBoxes==9){
                ResultDialog resultDialog=new ResultDialog(MainActivity.this,binding.playerOneName.getText().toString());
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }else {
            imageView.setImageResource(R.drawable.lettero;
            if (checkResults()){
                ResultDialog resultDialog =new ResultDialog()(MainActivity.this,binding.playerTwoName.getText().toString()
                        +"Is the Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if (totalSelectedBoxes==9){
                ResultDialog resultDialog=new ResultDialog(MainActivity.this,binding.playerTwoName.getText().toString());
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }

        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playeroneLayout.setBackgroundResource(R.drawable.white_box);
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
            binding.playeroneLayout.setBackgroundResource(R.drawable.black_border);
        }
    }

    private boolean checkResults() {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);

            if (boxPostions[combination[0]] == playerTurn && boxPostions[combination[1]] == playerTurn &&
                    boxPostions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;

    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPostions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

       public  void  restartMach(){
        boxPostions=new  int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalSelectedBoxes=1;

           binding.image1.setImageResource(R.drawable.white_box);
           binding.image2.setImageResource(R.drawable.white_box);
           binding.image3.setImageResource(R.drawable.white_box);
           binding.image4.setImageResource(R.drawable.white_box);
           binding.image5.setImageResource(R.drawable.white_box);
           binding.image6.setImageResource(R.drawable.white_box);
           binding.image7.setImageResource(R.drawable.white_box);
           binding.image8.setImageResource(R.drawable.white_box);
           binding.image9.setImageResource(R.drawable.white_box);


       }


}




package org.techtown.ossassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true; //입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; //계산된 결과 값을 저장하는 변수
    char operator = '+'; // 입력된 연산자를 저장하는 변수

    final String CLEAR_INPUT_TEXT = "0";

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_text);
    }

    public void buttonClick(View view) {
        Button getButton = findViewById(view.getId());

        Log.e("buttonClick", "default" + getButton.getText().toString() + "버튼이 클릭되었습니다.");



        switch (view.getId()) {
            case R.id.all_clear_button:
                isFirstInput = true;
                resultNumber = 0;
                operator = '+';
                resultText.setTextColor(0xFF666666);
                resultText.setText(CLEAR_INPUT_TEXT);
                break;

            case R.id.clear_entry_button:
                isFirstInput = true;
                resultText.setText(CLEAR_INPUT_TEXT);
                break;

            case R.id.back_space_button:
                if(resultText.getText().toString().length() > 1) {
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0, getResultText.length() - 1);
                    resultText.setText(subString);
               } else {
                    resultText.setTextColor(0xFF666666);
                    resultText.setText(CLEAR_INPUT_TEXT);
                    isFirstInput = true;
                }
                break;

            case R.id.decimal_button:
                break;

            case R.id.Addition_button:
            case R.id.subtraction_button:
            case R.id.division_button:
            case R.id.multiply_button:
                int lastNum = Integer.parseInt(resultText.getText().toString());
                if(operator == '+'){
                    resultNumber = resultNumber + lastNum;
                }else if(operator == '-') {
                    resultNumber = resultNumber - lastNum;
                }else if(operator == '/') {
                    resultNumber = resultNumber / lastNum;
                }else if(operator == '*') {
                    resultNumber = resultNumber * lastNum;
                }
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(resultNumber + "");
                isFirstInput = true;
                break;

            case R.id.result_button:
                if(operator == '+'){
                    resultNumber = resultNumber + Integer.parseInt(resultText.getText().toString());;
                }else if(operator == '-') {
                    resultNumber = resultNumber - Integer.parseInt(resultText.getText().toString());;
                }else if(operator == '/') {
                    resultNumber = resultNumber / Integer.parseInt(resultText.getText().toString());;
                }else if(operator == '*') {
                    resultNumber = resultNumber * Integer.parseInt(resultText.getText().toString());;
                }
                resultText.setText(resultNumber + "");
                isFirstInput = true;
                break;

            case R.id.num_0_button:
            case R.id.num_1_button:
            case R.id.num_2_button:
            case R.id.num_3_button:
            case R.id.num_4_button:
            case R.id.num_5_button:
            case R.id.num_6_button:
            case R.id.num_7_button:
            case R.id.num_8_button:
            case R.id.num_9_button:

                if (isFirstInput) {
                    resultText.setTextColor(0xFF000000);
                    resultText.setText(getButton.getText().toString());
                    isFirstInput = false;
                } else {
                    resultText.append(getButton.getText().toString());
                }
                break;

            default:
                //Toast.makeText(getApplicationContext(), getButton.getText().toString() + "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
                break;

        }
    }
}

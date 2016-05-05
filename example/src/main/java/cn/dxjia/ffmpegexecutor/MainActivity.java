package cn.dxjia.ffmpegexecutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.dxjia.ffmpeg.library.FFmpegNativeHelper;

public class MainActivity extends AppCompatActivity {

    EditText mInputEdit;
    TextView mResultBoard;

    private static final String testCommand = "ffmpeg -i /sdcard/demo.mp4 -vframes 30 -y -f gif /sdcard/demoout.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputEdit = (EditText) findViewById(R.id.command_input_edit);
        mResultBoard = (TextView) findViewById(R.id.result_board);
        mResultBoard.setMovementMethod(new ScrollingMovementMethod());

        findViewById(R.id.run_command).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCommand();
            }
        });

        FFmpegNativeHelper.init();
    }

    protected void onDestroy() {
        super.onDestroy();
        FFmpegNativeHelper.uninit();
    }

    private void runCommand() {
        clearResultBoard();
        String command = mInputEdit.getText().toString();
        if (TextUtils.isEmpty(command)) {
            command = testCommand;
        }
        String result = FFmpegNativeHelper.runCommand(command);
        updateResultBoard(result);
    }

    private void clearResultBoard() {
        mResultBoard.setText("");
        mResultBoard.scrollTo(0, 0);
    }

    private void updateResultBoard(String message) {
        String currentStr = mResultBoard.getText().toString();
        mResultBoard.setText(currentStr + "\n" + message);
    }
}

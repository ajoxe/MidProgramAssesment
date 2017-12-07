package nyc.c4q.midprogramassesment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {
    TextView loops;
    int startLoops = 0;
    int max = 10000;//1000000 takes took long, will update later if i have time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        loops = (TextView) findViewById(R.id.textview_loops);
        IntegerLoop integerLoop = new IntegerLoop();
        integerLoop.execute(startLoops);
        Intent loginActivity = new Intent(LoopActivity.this, LoginActivity.class);
        startActivity(loginActivity);
    }
    private class IntegerLoop extends AsyncTask<Integer, Integer, Integer> {


        @Override
        protected void onPreExecute() {
            loops.setText("Processing Loops");

        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i = 0; i < max ; i++) {
                startLoops += 1;
                publishProgress(startLoops);
            }
            return startLoops;

        }


        @Override
        protected void onProgressUpdate(Integer... n) {
            loops.setText("Loops Completed: " + n[0]);
        }

        @Override
        protected void onPostExecute(Integer n) {

            loops.setText("Total loops: " + n);
        }
    }


}

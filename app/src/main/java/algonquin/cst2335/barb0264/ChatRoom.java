package algonquin.cst2335.barb0264;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import algonquin.cst2335.barb0264.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.barb0264.databinding.SentMessageBinding;

public class ChatRoom extends AppCompatActivity {


    ActivityChatRoomBinding binding;
    ChatRoomViewModel chatModel;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chatModel = new ViewModelProvider(this).get(ChatRoomViewModel.class);
        ArrayList<String> messages = chatModel.messages.getValue();



        RecyclerView.Adapter adapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                SentMessageBinding rowBinding = SentMessageBinding.inflate(getLayoutInflater(), parent, false);

                // this will initialize the row variables:
                return new MyRowHolder(rowBinding);

            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                String obj = messages.get(position);
                holder.messageText.setText(obj);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String currentTime = sdf.format(new Date());
                holder.timeText.setText(currentTime);
            }

            @Override
            public int getItemCount() { //how many rows
                return messages.size();
            }
        };

        binding.theRecycleView.setAdapter(adapter);
        binding.theRecycleView.setLayoutManager(new LinearLayoutManager(this));

        binding.submit.setOnClickListener( click -> {
            String message = binding.messageInput.getText().toString();
            messages.add(message);
            chatModel.messages.postValue(messages); // Update messages in ViewModel

            adapter.notifyItemInserted(messages.size()-1);
            adapter.notifyDataSetChanged();

            binding.messageInput.setText(""); //REMOVE WHAT WAS TYPED
        });
    }

    class MyRowHolder extends RecyclerView.ViewHolder {

        TextView messageText;
        TextView timeText;

        public MyRowHolder(@NonNull SentMessageBinding binding) {
            super(binding.getRoot());
            messageText = binding.messageText;
            timeText = binding.timeText;
        }
    }
}
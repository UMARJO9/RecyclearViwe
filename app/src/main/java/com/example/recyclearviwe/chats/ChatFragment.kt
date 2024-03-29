package com.example.recyclearviwe.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclearviwe.R
import com.example.recyclearviwe.chats.adapter.ChatsAdapter
import com.example.recyclearviwe.profile.ProfileFragment
import com.example.recyclearviwe.ChatModel


class ChatFragment :Fragment(R.layout.fragment_chat) {

    private val recyclerView by lazy { requireView()
        .findViewById<RecyclerView>(R.id.recyclerViewChat)}
    private val adapter = ChatsAdapter()

    private val data = listOf(
        ChatModel("Bryan","What do you think?" , R.drawable.bryan),
        ChatModel("Kari","Looks great!" , R.drawable.kari),
        ChatModel("Diana","Lunch on Monday?" , R.drawable.diana),
        ChatModel("Ben","You sent a photo." , R.drawable.ben),
        ChatModel("Naomi","Naomi sent a photo." , R.drawable.naomi),
        ChatModel("Alicia","See you at 8." , R.drawable.alicia),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.updateItems(data)

        val textView = view.findViewById<TextView>(R.id.TextView)

        textView?.setOnClickListener {

            val profileFragment = ProfileFragment()
            parentFragmentManager.beginTransaction()
                .add(R.id.chats_fragment_container, profileFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
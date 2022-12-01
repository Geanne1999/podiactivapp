package com.example.podiactivapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.podiactivapp.R
import com.example.podiactivapp.repository.Adapter.PreviewAdapter
import com.example.podiactivapp.repository.Models.PreviewThreeDimViewModel
import com.google.firebase.database.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlbumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private lateinit var viewModel: PreviewThreeDimViewModel
private lateinit var previewRecyclerView:RecyclerView
lateinit var adapter: PreviewAdapter
lateinit var retrieveList: ArrayList<String>

class AlbumFragment : Fragment()
{
  // TODO: Rename and change types of parameters
  private var param1: String? = null
  private var param2: String? = null
  private lateinit var database: DatabaseReference
  private lateinit var imageAdapter:PreviewAdapter

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    arguments?.let {
      param1 = it.getString(ARG_PARAM1)
      param2 = it.getString(ARG_PARAM2)
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View?
  {
    // Inflate the layout for this fragment
    retrieveList= arrayListOf()
    return inflater.inflate(R.layout.fragment_album, container, false)
  }

  companion object
  {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        AlbumFragment().apply {
          arguments = Bundle().apply {
            putString(ARG_PARAM1, param1)
            putString(ARG_PARAM2, param2)
          }
        }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    previewRecyclerView = view.findViewById(R.id.recyclewViewPreviews)
    previewRecyclerView.setHasFixedSize(true)
    previewRecyclerView.layoutManager = LinearLayoutManager(context)

    database = FirebaseDatabase.getInstance("https://podiactiv-default-rtdb.europe-west1.firebasedatabase.app").getReference("3D/foot1")

    database.addValueEventListener(object : ValueEventListener {
      override fun onDataChange(snapshot: DataSnapshot) {
          snapshot.children.map { dataSnapshot ->
            retrieveList.add(dataSnapshot.getValue(String::class.java)!!)
          }
          imageAdapter = PreviewAdapter()
          previewRecyclerView.adapter = imageAdapter
          imageAdapter.setOnClickListener(object : PreviewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

              var stringUrlPhoto = retrieveList[position]
              val intent = Intent(activity, DetailProductActivity::class.java)
              intent.putExtra("photoFeet", stringUrlPhoto)
              startActivity(intent)
            }

          })
          Log.d("Images", retrieveList.toString())
      }

      override fun onCancelled(error: DatabaseError) {
        Toast.makeText(context, "Can't retrieve images!", Toast.LENGTH_SHORT).show()
      }
    })

  }

}
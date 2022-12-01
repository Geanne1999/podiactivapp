package com.example.podiactivapp.repository.Models

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import java.lang.Exception

class ThreeDimRepository {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance(" https://podiactiv-default-rtdb.europe-west1.firebasedatabase.app").getReference("3D")
    //private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("gs://podiactiv.appspot.com/3D").child("footScannerPreviewFil.PNG")

    @Volatile private var INSTANCE: ThreeDimRepository? = null

    fun getInstance(): ThreeDimRepository {

        return INSTANCE?: synchronized(this){

            val instance = ThreeDimRepository()
            INSTANCE = instance
            instance
        }
    }

    fun load3dPhotos(threeDimPhotoList: MutableLiveData<List<PreviewThreeDimModel>>){

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                try{
                    val previewList: List<PreviewThreeDimModel> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(PreviewThreeDimModel::class.java)!!
                    }

                    threeDimPhotoList.postValue(previewList)
                }catch (e: Exception){

                }
            }

            override fun onCancelled(error: DatabaseError) {
                // handle error
            }
        })
    }
}
package com.reviakin_package.clean_architecture.presentation.photo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.reviakin_package.clean_architecture.R
import com.reviakin_package.clean_architecture.databinding.FragmentPhotosBinding
import com.reviakin_package.clean_architecture.presentation.gallery.OnGalleryCallback
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ClassCastException

@AndroidEntryPoint
class PhotosFragment : Fragment(), OnPhotosAdapterListener {

    private lateinit var fragmentPhotosBinding: FragmentPhotosBinding
    private var adapter: PhotosAdapter? = null
    private var mCallback: OnGalleryCallback? = null
    private val viewModel: PhotosViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnGalleryCallback){
            mCallback = context
        }else throw ClassCastException(context.toString() + " must implement OnGalleryCallback")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PhotosAdapter(this)
        val albumId = arguments?.let { it.getLong(KEY_ALBUM_ID) }
        viewModel.loadPhotos(albumId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPhotosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)
        fragmentPhotosBinding.photosViewModel = viewModel
        fragmentPhotosBinding.photosRecyclerView.adapter = adapter

        viewModel.isLoad.observe(viewLifecycleOwner, {
            it?.let { visibility ->
                fragmentPhotosBinding.photosProgressBar.visibility = if (visibility) View.GONE else View.VISIBLE
            }
        })

        viewModel.photoListReceivedLiveData.observe(viewLifecycleOwner, {
            it?.let {
                adapter?.addData(it)
            }
        })

        return fragmentPhotosBinding.root
    }

    override fun gotoDetailPage(imageView: ImageView, id: Long) {
        mCallback?.gotroDetailPageByPhotoId(imageView, id)
    }

    override fun onDetach() {
        super.onDetach()
        mCallback = null
        adapter = null
    }

    companion object{

        val KEY_ALBUM_ID = "KEY_ALBUM_ID"
        val FRAGMENT_NAME = PhotosFragment::class.java.name

        @JvmStatic
        fun newInstance(id: Long) =
            PhotosFragment().apply {
                arguments = Bundle().apply {
                    putLong(KEY_ALBUM_ID, id)
                }
            }
    }
}
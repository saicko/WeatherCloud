package com.saickodevelopment.weathercloud.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.saickodevelopment.weathercloud.R;

/**
 * Created by Gary on 6/13/2015.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.error_title)).setMessage(context.getString(R.string.error_message)).setPositiveButton(context.getString(R.string.error_ok_button), null);

        AlertDialog dialog = builder.create();
        return dialog;
    

    }
}

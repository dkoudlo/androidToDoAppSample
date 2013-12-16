package com.todo.todolist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends Activity {
	String item;
	int pos;
	EditText etEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		item = getIntent().getStringExtra("item");
		pos = getIntent().getIntExtra("pos", 0);
		etEdit = (EditText) findViewById(R.id.etEditItem);
		etEdit.setText(item);
		etEdit.setSelection(item.length());
		
	}
	
	public void saveEdit(View v){
		EditText etItem = (EditText) findViewById(R.id.etEditItem);
		Intent i = new Intent();
		i.putExtra("item", etItem.getText().toString());
		i.putExtra("pos", pos);
		
		setResult(RESULT_OK, i);
		finish();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

}

package com.example.permisos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_CODE = 1,
            LOCATION_PERMISSION_CODE = 2,
            RECORD_PERMISSION_CODE = 3,
            CALENDAR_PERMISSION_CODE = 4,
            CAMERA_PERMISSION_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch SRequest = findViewById(R.id.switch1);
        SRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Ya tienes este permiso", Toast.LENGTH_LONG).show();
                } else {
                    requestStoragePermission();
                }
            }
        });

        Switch SRequest2 = findViewById(R.id.switch2);
        SRequest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Ya tienes este permiso", Toast.LENGTH_LONG).show();
                } else {
                    requestLocationPermission();
                }
            }
        });
        Switch SRequest3 = findViewById(R.id.switch3);
        SRequest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Ya tienes este permiso", Toast.LENGTH_LONG).show();
                } else {
                    requestCameraPermission();
                }
            }
        });
        Switch SRequest4 = findViewById(R.id.switch4);
        SRequest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Ya tienes este permiso", Toast.LENGTH_LONG).show();
                } else {
                    requestCalendarPermission();
                }
            }
        });
        Switch SRequest5 = findViewById(R.id.switch5);
        SRequest5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Ya tienes este permiso", Toast.LENGTH_LONG).show();
                } else {
                    requestRecorderPermission();
                }
            }
        });


    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this).setTitle("Permiso necesario").setMessage("..............").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                }
            })
                    .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            new AlertDialog.Builder(this).setTitle("Permiso necesario").setMessage("..............").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);
                }
            })
                    .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);
        }
    }

    private void requestRecorderPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
            new AlertDialog.Builder(this).setTitle("Permiso necesario").setMessage("..............").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_PERMISSION_CODE);
                }
            })
                    .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_PERMISSION_CODE);
        }
    }

    private void requestCalendarPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CALENDAR)) {
            new AlertDialog.Builder(this).setTitle("Permiso necesario").setMessage("..............").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_CALENDAR}, CALENDAR_PERMISSION_CODE);
                }
            })
                    .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CALENDAR}, CALENDAR_PERMISSION_CODE);
        }
    }

    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            new AlertDialog.Builder(this).setTitle("Permiso necesario").setMessage("..............").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
                }
            })
                    .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION_CODE:
            case LOCATION_PERMISSION_CODE:
            case RECORD_PERMISSION_CODE:
            case CALENDAR_PERMISSION_CODE:
            case CAMERA_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

